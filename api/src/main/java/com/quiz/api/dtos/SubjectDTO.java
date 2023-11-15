package com.quiz.api.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubjectDTO {

    private Integer id;
    private String title;
    private Integer parentId;

}
