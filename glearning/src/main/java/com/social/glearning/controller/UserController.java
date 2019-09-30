package com.social.glearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.glearning.model.User;
import com.social.glearning.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public String save(@RequestBody User user) {
		 return userService.createUser(user);
	}
	
	@GetMapping("/getbyid/{id}")
	public User	 getUserById(@PathVariable("id") String id) {
		 return userService.getUser(id);
	}
	
	@GetMapping("/getbyemail/{email}")
	public User	 getUserByEmail(@PathVariable("email") String email) {
		 return userService.getUserByEmail(email);
	}
}
