package com.springproject.triviaapprk22.question;

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
class QuestionServiceTest {
    @Mock QuestionRepository questionRepository;
    private QuestionService questionServiceUnderTest;

    @BeforeEach
    void setUp() {
        questionServiceUnderTest = new QuestionService(questionRepository);
    }

    @ParameterizedTest
    @ValueSource(ints = {5})
    public void canRequestQuestions(int amount) {
        // arrange
        // act
        questionServiceUnderTest.requestQuestions(amount);
        // assert
        verify(questionRepository).fetch(amount);
    }

    // TODO: Test number of multiple-choice questions results in 5.
    @ParameterizedTest
    @ValueSource(ints = {5})
    public void canFetchFiveQuestions(int amount) {
        // arrange
        // act
        List<Question> listOfQuestions = questionServiceUnderTest.requestQuestions(amount);
        // assert
        assertThat(listOfQuestions.size()).isEqualTo(amount);
    }

    @ParameterizedTest
    @ValueSource(ints = {5})
    public void willThrowWhenAmountOfQuestionsIsBelowAmount(int amount) {
        // arrange
        // act
        // assert
        assertThatThrownBy(() -> {
            List<Question> listOfQuestions = questionServiceUnderTest.requestQuestions(amount);
            Question question = listOfQuestions.get(0);
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