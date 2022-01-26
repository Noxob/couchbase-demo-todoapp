package com.ismailsamirusta.todoapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ismailsamirusta.todoapp.controller.TodoController;
import com.ismailsamirusta.todoapp.model.Todo;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class TodoControllerTest {
	
	@Autowired
	private TodoController todoController;

	private MockMvc mockMvc;
	
	ObjectMapper mapper = new ObjectMapper();
	ObjectWriter writer = mapper.writer();
	
	@PostConstruct
	public void createMocks() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(todoController).build();
	}
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(todoController).isNotNull();
	}
	
	@Test
	@WithMockUser("test_user")
    @Order(1)   
	public void getMyTodosAndCheckIfResultEqualsToZero() throws JsonProcessingException, Exception {
		mockMvc.perform(get("/todo/get/all").contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(0)));
	}

	@Test
	@WithMockUser("test_user")
    @Order(2)   
	public void saveNewTodo() throws JsonProcessingException, Exception {
		Todo todo1 = new Todo("title1", "description1", false, new Date());
		this.mockMvc.perform(post("/todo/save")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(mapper.writeValueAsString(todo1)))
	            .andExpect(status().isOk());
	}
	
	
	@Test
	@WithMockUser("test_user")
    @Order(3)   
	public void removeAddedTodo() throws JsonProcessingException, Exception {
		mockMvc.perform(get("/todo/remove/TODO:title1:test_user").contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser("test_user")
    @Order(4)   
	public void checkMyTodosAgainAndExpectZero() throws JsonProcessingException, Exception {
		mockMvc.perform(get("/todo/get/all").contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(0)));
	}

}
