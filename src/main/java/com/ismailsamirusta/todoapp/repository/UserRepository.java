package com.ismailsamirusta.todoapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ismailsamirusta.todoapp.model.AppUser;

@Repository
public interface UserRepository extends CrudRepository<AppUser, String>{
	
	public AppUser findByUsername(String username);
	
}
