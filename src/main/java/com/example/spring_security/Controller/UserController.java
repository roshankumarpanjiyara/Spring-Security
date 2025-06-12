package com.example.spring_security.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_security.Model.User;
import com.example.spring_security.Service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("register")
	public User register(@RequestBody User user) {
		userService.saveUser(user);
		return user;
	}
}
