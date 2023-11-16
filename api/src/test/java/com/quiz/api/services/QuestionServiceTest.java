package com.quiz.api.services;

import com.quiz.api.dtos.questionDTO.QuestionDTO;
import com.quiz.api.dtos.questionDTO.QuestionResponseDTO;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class QuestionServiceTest {

    @Mock
    static QuestionService questionService;
    static QuestionDTO questionDTO;
    static QuestionResponseDTO questionResponseDTO;

    @BeforeAll
    public static void init() {

        questionDTO = new QuestionDTO();
        questionDTO.setId(1);
        questionDTO.setContent("Question content test");
        questionDTO.setPoints(2);
        questionDTO.setNumberOfResponses(4);
        questionDTO.setNumberOfCorrectResponses(2);

        questionResponseDTO = new QuestionResponseDTO();
        questionResponseDTO.setId(questionDTO.getId());
        questionResponseDTO.setContent(questionDTO.getContent());
        questionResponseDTO.setPoints(questionDTO.getPoints());
        questionResponseDTO.setNumberOfResponses(questionDTO.getNumberOfResponses());
        questionResponseDTO.setNumberOfCorrectResponses(questionDTO.getNumberOfCorrectResponses());
    }

    @Test
    public void createQuestion() {

        when(questionService.save(questionDTO)).thenReturn(questionResponseDTO);
        QuestionResponseDTO returnedLevel = questionService.save(questionDTO);
        assertEquals(returnedLevel, questionResponseDTO);
    }

    @Test
    public void updateQuestion() {

        when(questionService.update(questionDTO)).thenReturn(questionResponseDTO);
        QuestionResponseDTO returnedLevel = questionService.update(questionDTO);
        assertEquals(returnedLevel, questionResponseDTO);
    }

    @Test
    public void findQuestionById() {

        when(questionService.findById(3)).thenReturn(questionResponseDTO);
        QuestionResponseDTO returnedLevel = questionService.findById(3);
        assertEquals(returnedLevel, questionResponseDTO);
    }

    @Test
    public void findAllQuestions() {

        List<QuestionResponseDTO> questions = new ArrayList<>();

        questions.add(questionResponseDTO);

        when(questionService.findAll()).thenReturn(questions);
        List<QuestionResponseDTO> returnedQuestions = questionService.findAll();
        assertEquals(returnedQuestions, questions);
    }

    @Test
    public void deleteQuestion() {

        // Todo delete a question test
    }

}
