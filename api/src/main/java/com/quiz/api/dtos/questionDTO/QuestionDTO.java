package com.quiz.api.dtos.questionDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionDTO {

    private Integer id;
    @Min(1)
    private Integer numberOfResponses;
    @Min(1)
    private Integer numberOfCorrectResponses;
    @NotBlank(message = "Content is required")
    private String content;
    @Min(1)
    private Integer points;
    @NotNull(message = "Level ID is required")
    private Integer levelId;
    @NotNull(message = "Subject ID is required")
    private Integer subjectId;

}
