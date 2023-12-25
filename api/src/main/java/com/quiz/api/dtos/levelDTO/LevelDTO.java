package com.quiz.api.dtos.levelDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LevelDTO {

    private Integer id;
    @NotBlank(message = "This field is required")
    private String description;
    @Min(1)
    private Integer maxPoints;
    @Min(1)
    private Integer minPoints;

}
