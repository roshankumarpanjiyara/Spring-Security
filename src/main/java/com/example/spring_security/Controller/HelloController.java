package com.example.spring_security.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
	
	@GetMapping("hello")
	public String hello(HttpServletRequest request) {
		return "Hello World " + request.getSession().getId();
	}
}
