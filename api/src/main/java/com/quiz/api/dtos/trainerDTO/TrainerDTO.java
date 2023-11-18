package com.quiz.api.dtos.trainerDTO;

import com.quiz.api.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrainerDTO extends User {

    private Integer id;
    private String speciality;

}
