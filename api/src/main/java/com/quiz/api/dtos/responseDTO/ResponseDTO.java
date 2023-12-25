package com.quiz.api.dtos.responseDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDTO {

    private Integer id;
    @NotBlank(message = "This field is required")
    private String content;

}
