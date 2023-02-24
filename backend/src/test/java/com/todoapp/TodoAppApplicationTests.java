package com.todoapp;

import com.todoapp.todo.TodoController;
import com.todoapp.todo.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
class TodoAppApplicationTests {

	@Autowired
	private TodoService todoservice;
	private MockMvc mockMvc;

	@BeforeEach
	void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new TodoController(todoservice)).build();
	}

	@Test
	void todoControllerTest() throws Exception {
		mockMvc.perform(get("/api/v1/todos").accept(MediaType.APPLICATION_JSON)).andExpect();
	}

}