package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.LoginForm;

@Controller 
public class HomeController {

  @GetMapping("/")
    public String loginForm(Model model) {
      LoginForm loginForm = new LoginForm();
      model.addAttribute("loginForm", loginForm);
        return "login";
    }

  @PostMapping("/login")
  public String loginSubmit(@ModelAttribute LoginForm loginForm, Model model) {
      String expectedUsername = "Software Engineering";
      String expectedPassword = "CSE2102";

      if (loginForm.getUsername().equals(expectedUsername) && loginForm.getPassword().equals(expectedPassword)) {
        model.addAttribute("loginMessage", "Login successful");
        return "redirect:quiz";
      } else {
        model.addAttribute("loginMessage", "Login failed. Please check your credentials.");
        return "login";
      }
    }

    @GetMapping("/quiz")
    public String quizPage() {
        return "quiz";
    }

    @GetMapping("/scores")
    public String scorePage() {
        return "test";
    }




}