package com.ismailsamirusta.todoapp.service;

import java.util.List;

import com.ismailsamirusta.todoapp.model.Todo;

public interface TodoService {
	
	public void save(Todo todo) throws Exception;
	public List<Todo> getAllTodos();
	public List<Todo> getMyTodos();
	public List<Todo> getTodosByComplete(boolean complete);
	public boolean removeTodoById(String id);
}
