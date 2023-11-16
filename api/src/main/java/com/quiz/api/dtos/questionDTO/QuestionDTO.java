package com.quiz.api.dtos.questionDTO;

import com.quiz.api.enums.ResponseType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionDTO {

    private Integer id;
    private Integer numberOfResponses;
    private Integer numberOfCorrectResponses;
    private String content;
    private Integer points;
    private Integer levelId;
    private Integer subjectId;

}
