package com.quiz.api.dtos.assignQuizDTO;

import com.quiz.api.models.Quiz;
import com.quiz.api.models.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AssignQuizDTO {

    private Integer id;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private Integer score;
    private String result;
    private Integer quizId;
    private Integer studentId;

}
