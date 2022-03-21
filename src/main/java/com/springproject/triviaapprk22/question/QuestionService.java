package com.springproject.triviaapprk22.question;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> requestQuestions(int amount) {
        List<Question> listOfQuestions = questionRepository.fetch(amount);
        return listOfQuestions;
    }

    public boolean checkAnswer(String correctAnswer, String submittedAnswer) {
        return new String(correctAnswer).equals(submittedAnswer);
    }
}
