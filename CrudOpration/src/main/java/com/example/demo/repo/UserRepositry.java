package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.User;

public interface UserRepositry extends JpaRepository<User, String> {

	Optional<User> findByEmail(String email);

	List<User> findByFisrtNameContaining(String keywords);

	// Optional<User> findByEmailAndPassword(String email,String password);
}
