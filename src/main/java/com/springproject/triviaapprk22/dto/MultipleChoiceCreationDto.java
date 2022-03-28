package com.springproject.triviaapprk22.dto;

import com.springproject.triviaapprk22.model.triviadata.MultipleChoiceQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultipleChoiceCreationDto {
    private MultipleChoiceQuestion[] questions;
    private int questionsIndex;

    public MultipleChoiceCreationDto() {
    }

    public MultipleChoiceCreationDto(int amount) {
        this.questions = new MultipleChoiceQuestion[amount];
    }

    public MultipleChoiceCreationDto(MultipleChoiceQuestion[] questions) {
        this.questions = questions;
        this.questionsIndex = -1;
    }

    public MultipleChoiceQuestion[] getQuestions() {
        return questions;
    }

    public void setQuestions(MultipleChoiceQuestion[] questions) {
        this.questions = questions;
    }

    public void addMultipleChoiceQuestion(MultipleChoiceQuestion multipleChoiceQuestion) {
        this.questions[++questionsIndex] = multipleChoiceQuestion;
    }

    public boolean isEmpty() {
        return questionsIndex == -1;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0 ; i < questions.length ; i++) {
            str+=(questions[i].toString());
        }
        return "MultipleChoiceCreationDto{" + str + '}';
    }
}
