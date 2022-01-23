package com.ismailsamirusta.todoapp.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ismailsamirusta.todoapp.model.AppUser;
import com.ismailsamirusta.todoapp.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user/register")
	public ResponseEntity<Map<String,String>> registerUser(@RequestBody AppUser user) {
		Map<String,String> responseMap = new HashMap<String,String>();
		HttpStatus status = HttpStatus.OK;
		try {
			userService.addUser(user);
			responseMap.put("success", "true");
		}catch(Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			responseMap.put("success", "false");
			responseMap.put("error", e.getMessage());
		}
		return new ResponseEntity<Map<String,String>>(responseMap, status);
	}
	
	@GetMapping("/user/myuser")
	public ResponseEntity<AppUser> getMyUser(Principal principal){
		return new ResponseEntity<AppUser>(userService.findByUsername(principal.getName()), HttpStatus.OK);
	}
}
