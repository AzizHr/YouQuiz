package com.quiz.api.dtos.assignQuizDTO;

import com.quiz.api.models.Quiz;
import com.quiz.api.models.Student;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AssignQuizDTO {

    private Integer id;
    @NotNull(message = "This field is required")
    private LocalDateTime startedAt;
    @NotNull(message = "This field is required")
    private LocalDateTime endedAt;
    @Min(1)
    private Integer score;
    @NotBlank(message = "This field is required")
    private String result;
    @NotBlank(message = "Quiz ID is required")
    private Integer quizId;
    @NotBlank(message = "Student ID is required")
    private Integer studentId;

}
