package com.springproject.triviaapprk22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TriviaAppRk22Application {

    public static void main(String[] args) {
        SpringApplication.run(TriviaAppRk22Application.class, args);
    }
}
