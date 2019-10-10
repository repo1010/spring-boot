package com.spring.springsecuritymysql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping("/")
	public String home() {
		return "<h1>Welcome to Home</h2>";
	}

	@GetMapping("/user")
	public String getUser() {
		return "<h1>Welcome User</h2>";
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		return "<h1>Welcome Admin</h2>";
	}
	
	
	
}
