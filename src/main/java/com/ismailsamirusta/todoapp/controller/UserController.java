package com.ismailsamirusta.todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ismailsamirusta.todoapp.model.AppUser;
import com.ismailsamirusta.todoapp.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/user/register")
	public void registerUser(@RequestBody AppUser user) {
		userService.addUser(user);
	}
	
	
}
