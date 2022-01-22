package com.ismailsamirusta.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ismailsamirusta.todoapp.model.Todo;
import com.ismailsamirusta.todoapp.service.TodoService;

@Controller
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping("/todo/get/all")
	public ResponseEntity<List<Todo>> getAllTodos(){
		return new ResponseEntity<List<Todo>>(todoService.getAllTodos(), HttpStatus.OK);
	}
	
	@PostMapping("/todo/create/new")
	public ResponseEntity<String> createNewTodo(@RequestBody Todo newTodo){
		try {
			todoService.createNew(newTodo);
			return new ResponseEntity<String>("Created.", HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
