package com.example.demo;

import com.example.demo.repository.QuizBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Arrays;

import com.example.demo.models.QuizForm;
import com.example.demo.models.SessionScore;
import com.example.demo.models.LoginForm;
import com.example.demo.service.ScoreService;

import com.example.demo.UsernameValidator;  //for login test created 

@Controller 
public class HomeController {

  @Autowired
  ScoreService scoreService;

  private final UsernameValidator usernameValidator;

    public HomeController(UsernameValidator usernameValidator) {
        this.usernameValidator = usernameValidator;
    }

  QuizBank quizBank = new QuizBank();

  // this could be replaced by a repository
  public SessionScore sessionScore = new SessionScore();

  @GetMapping("/")
    public String loginForm(Model model) {
      LoginForm loginForm = new LoginForm();
      model.addAttribute("loginForm", loginForm);
        return "login";
    }

  @PostMapping("/login")
  public String loginSubmit(@ModelAttribute LoginForm loginForm, Model model) {
        // Get the entered username and password from the loginForm
        String enteredUsername = loginForm.getUsername();
        String enteredPassword = loginForm.getPassword();

        // Check the username using the UsernameValidator
        if (usernameValidator.validateUsername(enteredUsername) && enteredPassword.equals("CSE2102")) {
            model.addAttribute("loginMessage", "Login successful");
            return "redirect:quiz";
        } else {
            model.addAttribute("loginMessage", "Login failed. Please check your credentials.");
            return "login";
        }
    }

    @GetMapping("/quiz")
    public String quizPage(Model model) {
      model.addAttribute("quizBank", quizBank);
      return "quiz";
    }

    @PostMapping("/quiz/submit")
    public String quizSubmit(@ModelAttribute("quizForm") QuizForm quizForm, Model model) {
        List<String> userAnswers = Arrays.asList(
            quizForm.getQuestion0(),
            quizForm.getQuestion1(),
            quizForm.getQuestion2(),
            quizForm.getQuestion3(),
            quizForm.getQuestion4()
        );


        int score = scoreService.calculateScore(userAnswers, quizBank);

        model.addAttribute("quizScore", score);

        sessionScore.setSessionScore(score);

        return "redirect:/scores";
    }

    @GetMapping("/scores")
    public String scorePage(Model model) {
        int score = sessionScore.getSessionScore();
        model.addAttribute("quizScore", score);
        return "score";
    }




}