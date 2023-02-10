package com.example.demo.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.UserDto;
import com.example.demo.entites.User;
import com.example.demo.repo.UserRepositry;
import com.example.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositry userRepositry;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userdto) {
		// generate unique id in string format
		String userId = UUID.randomUUID().toString();
		userdto.setUserId(userId);

		User user = dtoToEntity(userdto);
		User savedUser = userRepositry.save(user);

		UserDto newDto = entityToDto(savedUser);

		return newDto;
	}

	// entity to dto
	private UserDto entityToDto(User savedUser) {

		return modelMapper.map(savedUser, UserDto.class);
	}

	// Dto to entity
	private User dtoToEntity(UserDto userdto) {

		return modelMapper.map(userdto, User.class);
	}

	@Override
	public UserDto updateUser(UserDto userdto, String userId) {
		User user = userRepositry.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with given id "));
		user.setFirstname(userdto.getFirstname());
		user.setAge(userdto.getAge());
		user.setLastname(userdto.getLastname());
		// save data
		User updatedUser = userRepositry.save(user);
		UserDto updatedDto = entityToDto(updatedUser);
		return updatedDto;
	}

	@Override
	public void deleteUser(String userId) {
		User user = userRepositry.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with given id "));
		// delete user
		userRepositry.delete(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users = userRepositry.findAll();
		List<UserDto> dtoList = users.stream().map(user -> entityToDto(user)).collect(Collectors.toList());
		return dtoList;
	}

	@Override
	public UserDto getUser(String userId) {
		User user = userRepositry.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with given id "));
		return entityToDto(user);
	}

	@Override
	public UserDto getUserByEmail(String email) {
		User user = userRepositry.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("User not found with given email "));
		return entityToDto(user);
	}

	@Override
	public List<UserDto> searchUser(String keyword) {
		List<User> users = userRepositry.findByFisrtNameContaining(keyword);
		List<UserDto> dtoList = users.stream().map(user -> entityToDto(user)).collect(Collectors.toList());
		return dtoList;
	}

}
