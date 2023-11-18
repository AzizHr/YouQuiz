package com.quiz.api.dtos.quizDTO;

import com.quiz.api.dtos.assignQuizDTO.AssignQuizDTO;
import com.quiz.api.dtos.assignQuizDTO.AssignQuizResponseDTO;
import com.quiz.api.dtos.quizQuestionDTO.QuizQuestionDTO;
import com.quiz.api.dtos.trainerDTO.TrainerDTO;
import com.quiz.api.dtos.trainerDTO.TrainerResponseDTO;
import com.quiz.api.models.AssignQuiz;
import com.quiz.api.models.QuizQuestion;
import com.quiz.api.models.Trainer;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
public class QuizResponseDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer score;
    private Boolean showResponses;
    private Boolean showResult;
    private Integer numberOfChances;
    private String remarks;
    private LocalTime duration;
    private TrainerResponseDTO trainer;
    private List<QuizQuestionDTO> quizQuestions;
    private List<AssignQuizDTO> assignQuizzes;

}
