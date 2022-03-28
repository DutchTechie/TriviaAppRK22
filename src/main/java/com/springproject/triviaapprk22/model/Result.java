package com.springproject.triviaapprk22.model;

public class Result {
    private String correctAnswer;
    private String submittedAnswer;
    private String question;
    private String message;

    public Result(String question, String correctAnswer, String submittedAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.submittedAnswer = submittedAnswer;
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isCorrect() {
        return submittedAnswer.equals(correctAnswer);
    }

    @Override
    public String toString() {
        return "Result{" +
                "correctAnswer='" + correctAnswer + '\'' +
                ", submittedAnswer='" + submittedAnswer + '\'' +
                '}';
    }
}
