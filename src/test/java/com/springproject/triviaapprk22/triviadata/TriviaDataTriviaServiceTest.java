package com.springproject.triviaapprk22.triviadata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TriviaDataTriviaServiceTest {
    @Mock
    TriviaDataOldRepository triviaDataOldRepository;
    private TriviaDataService questionServiceUnderTest;

    @BeforeEach
    void setUp() {
        questionServiceUnderTest = new TriviaDataService(triviaDataOldRepository);
    }

    @ParameterizedTest
    @ValueSource(ints = {5})
    public void canRequestQuestions(int amount) {
        // arrange
        // act
        questionServiceUnderTest.requestQuestions(amount);
        // assert
        verify(triviaDataOldRepository).fetch(amount);
    }

    @ParameterizedTest
    @ValueSource(ints = {5})
    public void willThrowWhenAmountOfQuestionsIsBelowAmount(int amount) {
        // arrange
        // act
        // assert
        assertThatThrownBy(() -> {
            List<String> listOfQuestions = questionServiceUnderTest.requestQuestions(amount);
            String question = listOfQuestions.get(0);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void canCheckIfAnswerIsCorrect() {
        // arrange
        String correctAnswer = "answer 1";
        String submittedAnswer = "answer 1";
        // act
        boolean isAnswerCorrect = questionServiceUnderTest.checkAnswer(correctAnswer, submittedAnswer);
        // assert
        assertThat(isAnswerCorrect).isTrue();
    }

    @Test
    public void canCheckIfAnswerIsIncorrect() {
        // arrange
        String correctAnswer = "answer 1";
        String submittedAnswer = "answer 2";
        // act
        boolean isAnswerCorrect = questionServiceUnderTest.checkAnswer(correctAnswer, submittedAnswer);
        // assert
        assertThat(isAnswerCorrect).isFalse();
    }
}