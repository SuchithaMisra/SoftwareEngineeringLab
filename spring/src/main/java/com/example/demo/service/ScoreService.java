package com.example.demo.service;


import java.util.List;

import com.example.demo.repository.QuizBank;
import org.springframework.stereotype.Service;


@Service
public class ScoreService {


    public int calculateScore(List<String> userAnswers, QuizBank quizBank) {
        int score = 0;

        System.out.println(userAnswers.get(0));
        System.out.println(quizBank.get(0));

        for (int i = 0; i < userAnswers.size(); i++) {

            System.out.println(userAnswers.get(i));
            System.out.println(quizBank.get(i).getAnswer());
                if (userAnswers.get(i).equals(quizBank.get(i).getAnswer())) {
                score++;
            }
        }


        return score;
    }

    
}
