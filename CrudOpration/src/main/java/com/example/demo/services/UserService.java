package com.example.demo.services;

import java.util.List;

import com.example.demo.dtos.UserDto;

public interface UserService {
// create
	UserDto createUser(UserDto userdto);

//update user

	UserDto updateUser(UserDto userdto, String userId);

//delete user

	void deleteUser(String userId);

//getAll user

	List<UserDto> getAllUser();

//get single user by id

	UserDto getUser(String userId);

//get single user by email

	UserDto getUserByEmail(String email);

//search user
	List<UserDto> searchUser(String keyword);

}
