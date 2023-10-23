package com.example.demo.service;


import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class ScoreService {


    public int calculateScore(List<String> userAnswers, List<String> correctAnswers) {
        int score = 0;

        for (int i = 0; i < userAnswers.size(); i++) {
            if (userAnswers.get(i).equalsIgnoreCase(correctAnswers.get(i))) {
                score++;
            }
        }


        return score;
    }

    
}
