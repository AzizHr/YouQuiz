package com.quiz.api.dtos.answerDTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnswerDTO {

    private Integer id;
    @NotNull
    private Integer assignQuizId;
    @NotNull
    private Integer validationId;

}
