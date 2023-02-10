package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.UserDto;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto userdto1 = userService.createUser(userDto);
		return new ResponseEntity<>(userdto1, HttpStatus.CREATED);
	}

	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("userId") String userId, @RequestBody UserDto userDto)

	{
		UserDto updatedUserDto = userService.updateUser(userDto, userId);
		return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);

	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>("user is deleted successfully!!", HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);

	}

	@GetMapping("/email/{email}")
	public ResponseEntity<UserDto> getUser(@PathVariable String email) {
		return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
	}

}
