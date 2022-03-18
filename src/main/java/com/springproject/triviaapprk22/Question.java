package com.springproject.triviaapprk22;

public class Question {
    private final long id;
    private final String question;

    public Question(long id, String question) {
        this.id = id;
        this.question = question;
    }

    public long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }
}
