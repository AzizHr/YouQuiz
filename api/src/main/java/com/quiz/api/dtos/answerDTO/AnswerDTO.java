package com.quiz.api.dtos.answerDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnswerDTO {

    private Integer id;
    private Integer assignQuizId;
    private Integer validationId;

}
