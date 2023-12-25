package com.quiz.api.dtos.trainerDTO;

import com.quiz.api.models.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrainerDTO extends User {

    private Integer id;
    @NotBlank(message = "This field is required")
    private String speciality;

}
