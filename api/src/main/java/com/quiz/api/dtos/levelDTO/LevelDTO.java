package com.quiz.api.dtos.levelDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LevelDTO {

    private Integer id;
    private String description;
    private Integer maxPoints;
    private Integer minPoints;

}
