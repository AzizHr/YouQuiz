package com.quiz.api.dtos.quizQuestionDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
public class QuizQuestionDTO {

    private Integer id;
    @NotNull(message = "This field is required")
    private LocalTime duration;
    @NotNull(message = "Quiz ID is required")
    private Integer quizId;
    @NotNull(message = "Question ID is required")
    private Integer questionId;

}
