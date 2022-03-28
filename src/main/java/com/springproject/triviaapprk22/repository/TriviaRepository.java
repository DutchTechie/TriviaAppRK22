package com.springproject.triviaapprk22.repository;

// TODO: Check https://github.com/eugenp/tutorials/blob/950bbadc353bdca114befc98cf4a18476352220e/spring-web-modules/spring-resttemplate-2/src/main/java/com/baeldung/resttemplate/json/consumer/service/UserConsumerServiceImpl.java to complete this class

import com.springproject.triviaapprk22.model.triviadata.MultipleChoiceQuestion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// TODO: Edit the list with new MutlipleChoiceQuestion instances
@Repository
public class TriviaRepository {
    private static final String QUESTIONS_URI = "https://opentdb.com/api.php";

    // TODO: Update the following code to fetch actual data
    public List<MultipleChoiceQuestion> fetch(int amount) {
        String amountString = String.valueOf(amount);
        String uri = constructFullPathToApi(QUESTIONS_URI, "amount", amountString);
        List<MultipleChoiceQuestion> dummyQuestions = new ArrayList<>();

        // Create an array list
        ArrayList<String> incorrectAnswers = new ArrayList<>();
        ArrayList<String> incorrectAnswers2 = new ArrayList<>();

        // Add a couple of possible answers
        incorrectAnswers.add("Answer 1");
        incorrectAnswers.add("Answer 2");
        incorrectAnswers.add("Answer 3");

        incorrectAnswers2.add("Answer 2.1");
        incorrectAnswers2.add("Answer 2.2");

//        dummyQuestions.add(new MultipleChoiceQuestion(
//                1L,
//                "Question 1",
//                "Correct Answer 1",
//                incorrectAnswers));
//        dummyQuestions.add(new MultipleChoiceQuestion(
//                2L,
//                "Question 2",
//                "Correct Answer 2",
//                incorrectAnswers2));
//        return dummyQuestions;
        return Collections.emptyList();
    }

    private String constructFullPathToApi(String uri, String parameterName, String value) {
        String requestParameter = String.format("?%s=%s", parameterName, value);
        String completeUri = uri.concat(requestParameter);
        return completeUri;
    }
}
