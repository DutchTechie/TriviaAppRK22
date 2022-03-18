package com.springproject.triviaapprk22;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class QuestionsControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private QuestionsService questionsService;

    @Test
    void getAllQuestions() throws Exception {
        List<Question> listOfQuestions = new ArrayList<Question>();
        listOfQuestions.add(new Question(1L,"Question 1"));
        listOfQuestions.add(new Question(2L, "Question 2"));
        when(questionsService.getAll()).thenReturn(listOfQuestions);

        mockMvc.perform(
                MockMvcRequestBuilders.get("questions")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect((ResultMatcher) jsonPath("$", hasSize(2)))
                .andDo(print());
    }
}
