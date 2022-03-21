package com.springproject.triviaapprk22;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriviaAppController {
    // TODO: Add QuestionService instance here

    @RequestMapping("/questions")
    public String loadQuestions() {
        return "Questions";
    }

    @RequestMapping("/checkanswer")
    public String checkAnswer() {
        return "Goodbye from Spring Boot";
    }
}
