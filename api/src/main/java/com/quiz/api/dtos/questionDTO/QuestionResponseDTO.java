package com.quiz.api.dtos.questionDTO;

import com.quiz.api.dtos.levelDTO.LevelDTO;
import com.quiz.api.dtos.mediaDTO.MediaDTO;
import com.quiz.api.dtos.subjectDTO.SubjectDTO;
import com.quiz.api.dtos.validationDTO.ValidationDTO;
import com.quiz.api.enums.ResponseType;
import com.quiz.api.models.Media;
import lombok.Data;

import java.util.List;

@Data
public class QuestionResponseDTO {

    private Integer id;
    private Integer numberOfResponses;
    private Integer numberOfCorrectResponses;
    private String content;
    private ResponseType type;
    private Integer points;
    private LevelDTO level;
    private SubjectDTO subject;
    private List<ValidationDTO> validations;
    private List<MediaDTO> medias;


}
