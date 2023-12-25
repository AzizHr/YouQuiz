package com.quiz.api.dtos.subjectDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubjectDTO {

    private Integer id;
    @NotBlank(message = "This field is required")
    private String title;
    @NotNull(message = "Parent ID is required")
    private Integer parentId;

}
