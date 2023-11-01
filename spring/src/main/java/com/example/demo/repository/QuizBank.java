package com.example.demo.repository;


import java.util.List;
import java.util.ArrayList;
import com.example.demo.models.Question;

public class QuizBank {

    public static List<Question> quizBank = new ArrayList();

    public QuizBank() {
        quizBank.add(new Question("What is two plus two?", "5"));
        quizBank.add(new Question("What is two times two?", "4"));
        quizBank.add(new Question("What is two divided two?", "1"));
        quizBank.add(new Question("What is two modulo two?", "0"));
        quizBank.add(new Question("What is two to the power of two?", "4"));
    }

    public Question get(int i){
        return quizBank.get(i);
    }

    
}