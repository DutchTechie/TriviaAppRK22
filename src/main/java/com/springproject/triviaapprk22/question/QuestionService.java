package com.springproject.triviaapprk22.question;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    // May need to update the method return type
    public List<Question> requestQuestions(int amount) {
        // TODO: Load questions from an API
        return questionRepository.fetch(amount);
    }
}
