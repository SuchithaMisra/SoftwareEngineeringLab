package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.contains;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HomeController.class)   
class LoginPageTest {

	@Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("login successful test")
    public void testSuccessfulLogin() throws Exception {

        mockMvc.perform(get("/"))   
            .andExpect(status().isOk()) 
            .andExpect(content().string(containsString("Login")))
            .andExpect(content().string(containsString("Username:")))
            .andExpect(content().string(containsString("Password:")));
    }

}