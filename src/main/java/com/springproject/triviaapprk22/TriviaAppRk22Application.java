package com.springproject.triviaapprk22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

// FINALIZING
// TODO: Refactor code
// TODO: Add bootstrap
// TODO: Add a back button
// TODO: Delete triviadata
// TODO: Push to git
// TODO: Create the Readme file
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TriviaAppRk22Application {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(TriviaAppRk22Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}