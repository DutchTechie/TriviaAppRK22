package com.springproject.triviaapprk22.triviadata;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class TriviaDataService {
    private final TriviaDataOldRepository triviaDataOldRepository;

    public List<String> requestQuestions(int amount) {
        List<String> listOfQuestions = triviaDataOldRepository.fetch(amount);
        return listOfQuestions;
    }

    public boolean checkAnswer(String correctAnswer, String submittedAnswer) {
        return new String(correctAnswer).equals(submittedAnswer);
    }
}
