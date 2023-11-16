package com.quiz.api.dtos.levelDTO;

import com.quiz.api.dtos.questionDTO.QuestionDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class LevelResponseDTO {
    private Integer id;
    private String description;
    private Integer maxPoints;
    private Integer minPoints;
    private List<QuestionDTO> questions;
}
