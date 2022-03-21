package com.springproject.triviaapprk22.question;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepository {
    private final List<Question> questions;

    QuestionRepository() {
        this.questions = new ArrayList<Question>();
    }

    // TODO: Load questions from an API
    public List<Question> fetch(int amount) {
        return this.questions;
    }

    public void addQuestion(String question) {
        this.questions.add(new Question(question));
    }
}
