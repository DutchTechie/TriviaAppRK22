package com.springproject.triviaapprk22.question;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepository {
    private final List<Question> questions;

    QuestionRepository() {
        this.questions = new ArrayList<Question>();
        this.questions.add(new Question("question 1"));
        this.questions.add(new Question("question 2"));
    }

    public List<Question> fetch(int amount) {
        return this.questions;
    }
}
