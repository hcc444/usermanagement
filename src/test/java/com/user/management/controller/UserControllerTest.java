package com.user.management.controller;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testListUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].name", is("User1")))
                .andExpect(jsonPath("$[1].name", is("User2")))
                .andExpect(jsonPath("$[2].name", is("User3")));
    }
    
    @Test
	public void testGetUsersByRoleName() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/users/searchByRole/Role1").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].name", is("User1")))
				.andExpect(jsonPath("$[0].roleList[0].name", is("Role1")))
				.andExpect(jsonPath("$[1].name", is("User3")))
				.andExpect(jsonPath("$[1].roleList[0].name", is("Role1")));
    }
    
    @Test
	public void testUserGetMenu() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/users/1/menus").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("Menu1")))
                .andExpect(jsonPath("$[1].name", is("Menu2")));
	}
    
}