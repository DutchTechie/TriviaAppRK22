package com.springproject.triviaapprk22.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {
    @Mock QuestionRepository questionRepository;
    private QuestionService questionServiceUnderTest;

    @BeforeEach
    void setUp() {
        questionServiceUnderTest = new QuestionService(questionRepository);
    }

    // TODO: Test if repository fetch can is called by service
    @ParameterizedTest
    @ValueSource(ints = {5})
    public void canRequestQuestions(int amount) {
        questionServiceUnderTest.requestQuestions(amount);
        verify(questionRepository).fetch(amount);
    }

    // TODO: Make the test fail first
    // TODO: Test number of multiple-choice questions results in 5.

    // TODO: Make the test fail first
    // TODO: Test the correct answer is found in the list of possible answers

    // TODO: Make the test fail first
    // TODO: Test the incorrect answer is selected

    // TODO: Make the test fail first
    // TODO: Test the correct answer is selected

    // TODO: Make the test fail first
    // TODO: Test the correct answer belongs to the correct question
}