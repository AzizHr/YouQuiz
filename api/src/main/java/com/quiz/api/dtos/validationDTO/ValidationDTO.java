package com.quiz.api.dtos.validationDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ValidationDTO {

    private Integer id;
    @Min(1)
    private Integer points;
    @NotNull(message = "Question ID is required")
    private Integer questionId;
    @NotNull(message = "Response ID is required")
    private Integer responseId;

}
