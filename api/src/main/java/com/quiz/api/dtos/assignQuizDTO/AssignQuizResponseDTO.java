package com.quiz.api.dtos.assignQuizDTO;

import com.quiz.api.dtos.quizDTO.QuizDTO;
import com.quiz.api.dtos.studentDTO.StudentDTO;
import com.quiz.api.models.Quiz;
import com.quiz.api.models.Student;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AssignQuizResponseDTO {

    private Integer id;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private Integer score;
    private String result;
    private QuizDTO quiz;
    private StudentDTO student;

}
