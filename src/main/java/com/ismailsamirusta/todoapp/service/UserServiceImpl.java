package com.ismailsamirusta.todoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ismailsamirusta.todoapp.model.AppUser;
import com.ismailsamirusta.todoapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository UserRepository;
	
	@Override
	public void addUser(AppUser user) {
		UserRepository.save(user);
	}

	@Override
	public AppUser findByUsername(String username) {
		return UserRepository.findByUsername(username);
	}
		
}
