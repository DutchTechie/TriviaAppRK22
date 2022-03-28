package com.springproject.triviaapprk22.service;

import com.springproject.triviaapprk22.model.triviadata.MultipleChoiceQuestion;

import java.util.List;

public interface TriviaService {
    List<MultipleChoiceQuestion> findAll(int amount);
}
