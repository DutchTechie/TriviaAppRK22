package com.springproject.triviaapprk22.question;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> requestQuestions(int amount) {
        // TODO: Load questions from an API
        List<Question> listOfQuestions = questionRepository.fetch(amount);
        return questionRepository.fetch(amount);
    }

    public boolean checkAnswer(String correctAnswer, String submittedAnswer) {
        return true;
    }
}
