package com.quiz.api.dtos.answerDTO;

import com.quiz.api.dtos.assignQuizDTO.AssignQuizDTO;
import com.quiz.api.dtos.validationDTO.ValidationDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnswerResponseDTO {

    private Integer id;
    private AssignQuizDTO assignQuiz;
    private ValidationDTO validation;

}
