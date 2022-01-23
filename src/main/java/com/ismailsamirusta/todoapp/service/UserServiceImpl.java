package com.ismailsamirusta.todoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ismailsamirusta.todoapp.model.AppUser;
import com.ismailsamirusta.todoapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcrypto;
	
	private final String USER_ID_PREFIX="USER:";
	
	@Override
	public void addUser(AppUser user) {
		user.setId(USER_ID_PREFIX+user.getUsername());
		user.setPassword(bcrypto.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public AppUser findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
		
}
