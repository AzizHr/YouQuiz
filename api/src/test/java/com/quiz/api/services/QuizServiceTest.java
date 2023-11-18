package com.quiz.api.services;

import com.quiz.api.dtos.quizDTO.QuizDTO;
import com.quiz.api.dtos.quizDTO.QuizResponseDTO;
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
public class QuizServiceTest {

    @Mock
    static QuizService quizService;
    static QuizDTO quizDTO;
    static QuizResponseDTO quizResponseDTO;

    @BeforeAll
    public static void init() {

        quizDTO = new QuizDTO();

        quizResponseDTO = new QuizResponseDTO();

    }

    @Test
    public void createQuiz() {

        when(quizService.save(quizDTO)).thenReturn(quizResponseDTO);
        QuizResponseDTO returnedQuiz = quizService.save(quizDTO);
        assertEquals(returnedQuiz, quizResponseDTO);
    }

    @Test
    public void updateQuiz() {

        when(quizService.update(quizDTO)).thenReturn(quizResponseDTO);
        QuizResponseDTO returnedQuiz = quizService.update(quizDTO);
        assertEquals(returnedQuiz, quizResponseDTO);
    }

    @Test
    public void findQuizById() {

        when(quizService.findById(3)).thenReturn(quizResponseDTO);
        QuizResponseDTO returnedQuiz = quizService.findById(3);
        assertEquals(returnedQuiz, quizResponseDTO);
    }

    @Test
    public void findAllQuizzes() {

        List<QuizResponseDTO> quizzes = new ArrayList<>();

        quizzes.add(quizResponseDTO);

        when(quizService.findAll()).thenReturn(quizzes);
        List<QuizResponseDTO> returnedQuizzes = quizService.findAll();
        assertEquals(returnedQuizzes, quizzes);
    }

    @Test
    public void deleteQuiz() {

        // Todo delete a quiz test
    }

}
