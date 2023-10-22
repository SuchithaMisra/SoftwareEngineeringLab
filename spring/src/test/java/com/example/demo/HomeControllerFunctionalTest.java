package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.models.LoginForm;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.Map;

@WebMvcTest(HomeController.class)
public class HomeControllerFunctionalTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HomeController homeController;

    @Test
    public void testLogin() throws Exception {
        LoginForm loginForm = new LoginForm();
        loginForm.setPassword("CSE2102");
        loginForm.setUsername("Software Engineering");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .flashAttr("loginForm", loginForm))
                .andExpect(status().isOk())
                .andExpect(view().name("login"))
                .andReturn();
        
    }

    
}