package com.example.demo.models;

import java.util.UUID;
import jakarta.persistence.Getter;
import jakarta.persistence.Setter;
import jakarta.persistence.NoArgsConstructor;
import jakarta.persistence.AllArgsContructor;



@Getter 
@Setter
@NoArgsConstructor 
@AllArgsContructor
public class Question {


    private String question;

    private String answer;


}