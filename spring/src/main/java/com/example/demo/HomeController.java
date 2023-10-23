package com.example.demo;

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

@Controller 
public class HomeController {

  @Autowired
  ScoreService scoreService;

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

    @PostMapping("/quiz/submit")
    public String quizSubmit(@ModelAttribute("quizForm") QuizForm quizForm, Model model) {
        List<String> userAnswers = Arrays.asList(
            quizForm.getQuestion1(),
            quizForm.getQuestion2(),
            quizForm.getQuestion3(),
            quizForm.getQuestion4(),
            quizForm.getQuestion5()
        );

        List<String> correctAnswers = Arrays.asList("test", "test", "test", "test", "test");

        int score = scoreService.calculateScore(userAnswers, correctAnswers);

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