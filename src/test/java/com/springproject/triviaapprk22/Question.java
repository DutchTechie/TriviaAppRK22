package com.springproject.triviaapprk22;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Question {
    private String question;
    private Long id;

    public Question(long id, String question) {
        this.id = id;
        this.question = question;
    }

    public Question() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
