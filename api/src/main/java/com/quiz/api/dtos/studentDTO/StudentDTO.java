package com.quiz.api.dtos.studentDTO;

import com.quiz.api.models.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class StudentDTO extends User {

    private Integer id;
    @NotNull(message = "This field is required")
    private LocalDate registeredAt;

}
