package com.springproject.triviaapprk22;

import com.springproject.triviaapprk22.dto.MultipleChoiceCreationDto;
import com.springproject.triviaapprk22.model.triviadata.MultipleChoiceQuestion;
import com.springproject.triviaapprk22.model.Result;
import com.springproject.triviaapprk22.model.triviadata.TriviaData;
import com.springproject.triviaapprk22.repository.TriviaRepository;
import com.springproject.triviaapprk22.service.InMemoryTriviaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

// this.service = new InMemoryTriviaService(repository);
// multipleChoiceQuestions = service.findAll(5);

@Controller
public class TriviaAppController {
    // private static List<MultipleChoiceQuestion> multipleChoiceQuestions;
    private static TriviaRepository repository;
    private InMemoryTriviaService service;
    private RestTemplate restTemplate;
    private static final String QUESTIONS_URI = "https://opentdb.com/api.php";
    private TriviaData triviaData;
    private MultipleChoiceQuestion[] questions;

    public TriviaAppController() {
        this.repository = new TriviaRepository();
        restTemplate = new RestTemplate();
        String uri = constructFullPathToApi(QUESTIONS_URI, "amount", String.valueOf(2));
        triviaData = restTemplate.getForObject(uri, TriviaData.class);
        questions = triviaData.getMultipleChoiceQuestions();
    }

    private String constructFullPathToApi(String uri, String parameterName, String value) {
        String requestParameter = String.format("?%s=%s", parameterName, value);
        String completeUri = uri.concat(requestParameter);
        return completeUri;
    }

    @GetMapping(value = "/questions")
    public String showTriviaApp(Model model) {
        MultipleChoiceCreationDto listOfQuestions = new MultipleChoiceCreationDto(questions);
        model.addAttribute("form", listOfQuestions);
        System.out.println(listOfQuestions);
        return "main";
    }

    @PostMapping(value = "/checkanswer")
    public String checkAnswer(@ModelAttribute("form") MultipleChoiceCreationDto form, Model model) {
        System.out.println(form.toString());
        List<Result> results = new ArrayList<>();
        IntStream
                .range(0, questions.length)
                .forEach(index -> {
                    String question = questions[index].getQuestion();
                    String correctAnswer = questions[index].getCorrectAnswer();
                    String submittedAnswer = form.getQuestions()[index].getSubmittedAnswer();
                    Result result = new Result(question, correctAnswer, submittedAnswer);
                    if (result.isCorrect()) {
                        result.setMessage("This answer is correct.");
                    } else {
                        result.setMessage("This answer is not correct");
                    }
                    results.add(result);
                });
         model.addAttribute("results", results);
        return "results";
    }
}

