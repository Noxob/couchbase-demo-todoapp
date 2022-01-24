package com.ismailsamirusta.todoapp.service;

import java.util.Date;
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
	public void save(Todo todo) throws Exception {
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String id =TODO_ID_PREFIX + todo.getTitle().replace(" ", "_")+":"+user;
		Todo tempTodo = todoRepository.findById(id).orElse(null);
		
		if(todo.getId()==null) {
			if(tempTodo != null) {
				throw new Exception("You already have a todo with the same name!");
			}else {
				todo.setId(id);
			}
		}
		if(todo.getCreated()==null) {
			todo.setCreated(new Date());
		}else {
			todo.setUpdated(new Date());
		}
		if(todo.getUser()==null) {
			todo.setUser(user);
		}else if (!todo.getUser().equals(user)) {
			throw new Exception("You can only change your own todos!");
		}
		
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

	@Override
	public boolean removeTodoById(String id) {
		todoRepository.deleteById(id);
		return true;
	}

}
