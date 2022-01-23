package com.ismailsamirusta.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ismailsamirusta.todoapp.model.Todo;
import com.ismailsamirusta.todoapp.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	private TodoRepository todoRepository;
	
	private final String TODO_ID_PREFIX = "TODO:";
	
	@Override
	public void createNew(Todo todo) {
		todo.setUser(SecurityContextHolder.getContext().getAuthentication().getName());
		todo.setId(TODO_ID_PREFIX + todo.getTitle().replace(" ", "_")+":"+todo.getCreated().getTime());
		todoRepository.save(todo);
	}
	
	@Override
	public List<Todo> getAllTodos() {
		return (List<Todo>) todoRepository.findAll();
	}

	@Override
	public List<Todo> getMyTodos() {
		return todoRepository.findByUser(SecurityContextHolder.getContext().getAuthentication().getName());
	}

	@Override
	public List<Todo> getTodosByComplete(boolean complete) {
		return todoRepository.findByComplete(complete);
	}

}
