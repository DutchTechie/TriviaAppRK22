package com.springproject.triviaapprk22.model.triviadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

// TODO: Add the annotation to use different key named attr.
@JsonIgnoreProperties(ignoreUnknown = true)
public class TriviaData {
    @JsonProperty("results")
    private MultipleChoiceQuestion[] multipleChoiceQuestions;

    public MultipleChoiceQuestion[] getMultipleChoiceQuestions() {
        return multipleChoiceQuestions;
    }

    public void setMultipleChoiceQuestions(MultipleChoiceQuestion[] multipleChoiceQuestions) {
        this.multipleChoiceQuestions = multipleChoiceQuestions;
    }

    @Override
    public String toString() {
        return "TriviaData{" +
                "multipleChoiceQuestions=" + Arrays.toString(multipleChoiceQuestions) +
                '}';
    }
}
