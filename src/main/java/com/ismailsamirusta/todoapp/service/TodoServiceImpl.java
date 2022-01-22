package com.ismailsamirusta.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ismailsamirusta.todoapp.model.Todo;
import com.ismailsamirusta.todoapp.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	private TodoRepository todoRepository;
	
	@Override
	public void createNew(Todo todo) {
		todo.setId(todo.getTitle().replace(" ", "_")+":"+todo.getCreated().getTime());
		todoRepository.save(todo);
	}
	
	@Override
	public List<Todo> getAllTodos() {
		return (List<Todo>) todoRepository.findAll();
	}

}
