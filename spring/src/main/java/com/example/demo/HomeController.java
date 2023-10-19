package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class HomeController {

  @GetMapping("/")
  public String home() {
    return "home";
  }

  @GetMapping("/not_home")
  public String notHome() {
    return "not_home";
  }

  @GetMapping("/test")
  public String testPage() {
    return "test";
  }

  /* TO DO :
   * 
   *    IMPLEMENT THESE SCREENS BASED ON THE PROJECT DIAGRAM
   */

  @GetMapping("/login")
  public String login(){
    return "login";
  }

  @GetMapping("/questions")
  public String questions(){
    return "questions";
  }

  @GetMapping("/score")
  public String score(){
    return "score";
  }



}