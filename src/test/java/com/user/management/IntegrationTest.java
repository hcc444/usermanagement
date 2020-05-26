package com.user.management;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

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
	
	    
    @Test
	public void testListRoles() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/roles").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0].name", is("Role1")))
				.andExpect(jsonPath("$[0].menuList", hasSize(1)))
				.andExpect(jsonPath("$[0].menuList[0].name", is("Menu1")))
				.andExpect(jsonPath("$[1].name", is("Role2")))
				.andExpect(jsonPath("$[1].menuList", hasSize(1)))
				.andExpect(jsonPath("$[1].menuList[0].name", is("Menu2")))
				.andExpect(jsonPath("$[2].name", is("Role3")))
				.andExpect(jsonPath("$[2].menuList", hasSize(2)))
				.andExpect(jsonPath("$[2].menuList[0].name", is("Menu1")))
				.andExpect(jsonPath("$[2].menuList[1].name", is("Menu3")));
	}
	
	@Test
	public void testListMenus() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/menus").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0].name", is("Menu1")))
				.andExpect(jsonPath("$[1].name", is("Menu2")))
				.andExpect(jsonPath("$[2].name", is("Menu3")));

    }
}
