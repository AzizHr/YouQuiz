package com.quiz.api.dtos.mediaDTO;

import com.quiz.api.dtos.questionDTO.QuestionDTO;
import com.quiz.api.enums.MediaType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MediaDTO {

    private Integer id;
    @NotBlank(message = "Type is required")
    private MediaType type;
    @NotBlank(message = "Url is required")
    private String url;
    @NotNull(message = "Question ID is required")
    private Integer questionId;

}
