package com.ismailsamirusta.todoapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ismailsamirusta.todoapp.model.Todo;
import com.ismailsamirusta.todoapp.service.TodoService;

@Controller
@RequestMapping("todo")
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping("/get/all")
	public ResponseEntity<List<Todo>> getAllTodos(){
		return new ResponseEntity<List<Todo>>(todoService.getMyTodos(), HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Map<String, String>> saveTodo(@RequestBody Todo newTodo){
		Map<String, String> returnMap = new HashMap<String,String>();
		try {
			todoService.save(newTodo);
			returnMap.put("success", "true");
			return new ResponseEntity<Map<String, String>>(returnMap, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			returnMap.put("error", e.getMessage());
			returnMap.put("success", "false");
			return new ResponseEntity<Map<String, String>>(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/remove/{id}")
	public ResponseEntity<Map<String, String>> removeTodo(@PathVariable String id){
		Map<String, String> returnMap = new HashMap<String,String>();
		try {
			todoService.removeTodoById(id);
			returnMap.put("success", "true");
			return new ResponseEntity<Map<String, String>>(returnMap, HttpStatus.OK);
		}catch(Exception e) {
			returnMap.put("error", e.getMessage());
			returnMap.put("success", "false");
			return new ResponseEntity<Map<String, String>>(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
