package com.example.demo;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.demo.models.QuizForm;
import com.example.demo.service.ScoreService;
import org.junit.jupiter.api.Test;
import com.example.demo.repository.QuizBank;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class QuizBankTest {

    @InjectMocks
    QuizBank quizBank;
    @Mock
    ScoreService scoreService;

    @Test
    public void testGetQuestion() {
        QuizBank quizBank = new QuizBank();
        assertEquals("What is two plus two?", quizBank.get(0).getQuestion());
        assertEquals("What is two times two?", quizBank.get(1).getQuestion());
        assertEquals("What is two divided two?", quizBank.get(2).getQuestion());
        assertEquals("What is two modulo two?", quizBank.get(3).getQuestion());
        assertEquals("What is two to the power of two?", quizBank.get(4).getQuestion());
    }

    @Test
    public void testGetAnswer() {
        QuizBank quizBank = new QuizBank();
        assertEquals("4", quizBank.get(0).getAnswer());
        assertEquals("4", quizBank.get(1).getAnswer());
        assertEquals("1", quizBank.get(2).getAnswer());
        assertEquals("0", quizBank.get(3).getAnswer());
        assertEquals("4", quizBank.get(4).getAnswer());
    }


    @Test
    public void testScoreCalculator() {
        QuizForm quizForm = new QuizForm();
        quizForm.setQuestion0("4");
        quizForm.setQuestion1("4");
        quizForm.setQuestion2("4");
        quizForm.setQuestion3("4");
        quizForm.setQuestion4("4");

        when(scoreService.calculateScore(any(), any())).thenReturn(3);

        List<String> userAnswers = Arrays.asList(
                quizForm.getQuestion0(),
                quizForm.getQuestion1(),
                quizForm.getQuestion2(),
                quizForm.getQuestion3(),
                quizForm.getQuestion4()
        );
        int expectedScore = 3;
        int actualScore = scoreService.calculateScore(userAnswers, quizBank);
        assertEquals(expectedScore, actualScore);

    }

}