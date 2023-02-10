package com.example.demo.dtos;

public class UserDto {
	private String userId;

	private String firstname;
	private String lastname;
	private String email;

	private int age;

	public UserDto(String userId, String firstname, String lastname, String email, int age) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.age = age;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
