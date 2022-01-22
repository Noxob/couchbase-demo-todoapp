package com.ismailsamirusta.todoapp.service;

import com.ismailsamirusta.todoapp.model.AppUser;

public interface UserService {
	
	public void addUser(AppUser user);
	
	public AppUser findByUsername(String username);
}
