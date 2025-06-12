package com.example.spring_security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.spring_security.Model.User;
import com.example.spring_security.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	private BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(12);
	
	public User saveUser(User user) {
		user.setPassword(bcrypt.encode(user.getPassword()));
		System.out.println(user.getPassword());
		return userRepo.save(user);
	}
}
