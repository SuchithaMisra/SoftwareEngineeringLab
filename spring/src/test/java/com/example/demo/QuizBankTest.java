package com.example.demo;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.example.demo.repository.QuizBank;

public class QuizBankTest {

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
        assertEquals("5", quizBank.get(0).getAnswer());
        assertEquals("4", quizBank.get(1).getAnswer());
        assertEquals("1", quizBank.get(2).getAnswer());
        assertEquals("0", quizBank.get(3).getAnswer());
        assertEquals("4", quizBank.get(4).getAnswer());
    }

}