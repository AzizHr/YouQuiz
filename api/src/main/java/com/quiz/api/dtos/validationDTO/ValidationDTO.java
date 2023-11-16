package com.quiz.api.dtos.validationDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ValidationDTO {

    private Integer id;
    private Integer points;
    private Integer questionId;
    private Integer responseId;

}
