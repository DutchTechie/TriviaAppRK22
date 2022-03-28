package com.springproject.triviaapprk22.model.triviadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MultipleChoiceQuestion {
    private String category;
    private String type;
    private String difficulty;
    private String question;
    @JsonProperty("incorrect_answers")
    private String[] incorrectAnswers;
    @JsonProperty("correct_answer")
    private String correctAnswer;
    private String submittedAnswer;

    public MultipleChoiceQuestion() {}

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String[] getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(String[] incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public String[] getPossibleAnswers() {
        List<String> possibleAnswers = new ArrayList<>();
        String[] possibleAnswersArray = new String[this.incorrectAnswers.length + 1];
        possibleAnswers.add(correctAnswer);
        for (int i = 0; i < incorrectAnswers.length; i++) {
            boolean add = possibleAnswers.add(incorrectAnswers[i]);
        }
        Collections.shuffle(possibleAnswers);
        return possibleAnswers.toArray(possibleAnswersArray);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getSubmittedAnswer() {
        return submittedAnswer;
    }

    public void setSubmittedAnswer(String submittedAnswer) {
        this.submittedAnswer = submittedAnswer;
    }

    @Override
    public String toString() {
        return "MultipleChoiceQuestion{" +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", question='" + question + '\'' +
                ", incorrectAnswers=" + Arrays.toString(incorrectAnswers) +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", submittedAnswer='" + submittedAnswer + '\'' +
                '}';
    }
}
