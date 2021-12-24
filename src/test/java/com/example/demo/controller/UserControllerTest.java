package com.example.demo.controller;

import com.example.demo.MyAppTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@MyAppTest
class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserController userController;

	@Test
	void contextLoads() throws Exception {
		mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void getUserByName() throws Exception {
		mockMvc.perform(get("/getUser/MyName"))
				.andDo(print())
				.andExpect(status().isOk());
	}

}
