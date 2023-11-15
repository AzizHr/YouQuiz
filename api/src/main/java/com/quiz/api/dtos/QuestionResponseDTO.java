package com.quiz.api.dtos;

import com.quiz.api.enums.ResponseType;
import lombok.Data;

@Data
public class QuestionResponseDTO {

    private Integer numberOfResponses;
    private Integer numberOfCorrectResponses;
    private String content;
    private ResponseType type;
    private Integer points;
    private LevelDTO level;
    private SubjectDTO subject;


}
