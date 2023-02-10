package com.example.demo.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String userId;

	@Column(name = "FirstName")
	private String firstname;

	@Column(name = "LastName")
	private String lastname;

	@Column(name = "email")
	private String email;

	@Column(name = "age")
	private int age;

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

	public User(String userId, String firstname, String lastname, String email, int age) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.age = age;
	}

	public User() {
		super();

	}

}
