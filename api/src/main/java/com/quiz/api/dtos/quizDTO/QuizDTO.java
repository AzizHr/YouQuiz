package com.quiz.api.dtos.quizDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class QuizDTO {

    private Integer id;
    @Min(1)
    private Integer score;
    @NotNull(message = "This field is required")
    private Boolean showResponses;
    @NotNull(message = "This field is required")
    private Boolean showResult;
    @Min(1)
    private Integer numberOfChances;
    @NotBlank(message = "Remarks is required")
    private String remarks;
    @NotNull(message = "This field is required")
    private LocalTime duration;
    @NotNull(message = "Trainer ID is required")
    private Integer trainerId;

}
