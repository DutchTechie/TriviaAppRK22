package com.springproject.triviaapprk22.triviadata;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

// TODO: Check https://github.com/eugenp/tutorials/blob/950bbadc353bdca114befc98cf4a18476352220e/spring-web-modules/spring-resttemplate-2/src/main/java/com/baeldung/resttemplate/json/consumer/service/UserConsumerServiceImpl.java to complete this class

@Repository
public class TriviaDataOldRepository {
    private static final String QUESTIONS_URI = "https://opentdb.com/api.php";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private final RestTemplate restTemplate;

    public TriviaDataOldRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // TODO: Update the following code to fetch actual data
    public List<String> fetch(int amount) {
        String amountString = String.valueOf(amount);
        String uri = constructFullPathToApi(QUESTIONS_URI, "amount", amountString);
        List<String> data = Collections.emptyList();
        return data;
    }

    private String constructFullPathToApi(String uri, String parameterName, String value) {
        String requestParameter = String.format("?%s=%s", parameterName, value);
        String completeUri = uri.concat(requestParameter);
        return completeUri;
    }
}
