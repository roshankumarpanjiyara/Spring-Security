package com.example.spring_security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_security.Model.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}
