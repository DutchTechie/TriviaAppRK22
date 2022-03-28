package com.springproject.triviaapprk22.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springproject.triviaapprk22.model.triviadata.MultipleChoiceQuestion;
import com.springproject.triviaapprk22.repository.TriviaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryTriviaService implements TriviaService  {
    private static TriviaRepository repository;
    private static ObjectMapper objectMapper;

    public InMemoryTriviaService(TriviaRepository repository) {
        this.objectMapper = new ObjectMapper(); // TODO: Consider injecting
        this.repository = repository;
    }

    @Override
    public List<MultipleChoiceQuestion> findAll(int amount) {
        return repository.fetch(amount);
    }
}
