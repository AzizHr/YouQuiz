package com.quiz.api.dtos.validationDTO;

import com.quiz.api.dtos.questionDTO.QuestionDTO;
import com.quiz.api.dtos.responseDTO.ResponseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ValidationResponseDTO {

    private Integer id;
    private Integer points;
    private QuestionDTO question;
    private ResponseDTO response;

}
