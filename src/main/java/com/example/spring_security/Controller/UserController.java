package com.example.spring_security.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_security.Model.User;
import com.example.spring_security.Service.JWTService;
import com.example.spring_security.Service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JWTService jwtService;

	@PostMapping("register")
	public User register(@RequestBody User user) {
		userService.saveUser(user);
		return user;
	}
	
	@PostMapping("login")
	public String login(@RequestBody User user) {
		Authentication auth = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		
		if(auth.isAuthenticated()) {
			return jwtService.generateToken(user.getUsername());
		}else {
			return "Login Failed";
		}
	}
}
