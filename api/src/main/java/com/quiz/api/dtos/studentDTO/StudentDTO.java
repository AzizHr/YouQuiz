package com.quiz.api.dtos.studentDTO;

import com.quiz.api.models.AssignQuiz;
import com.quiz.api.models.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class StudentDTO extends User {

    private Integer id;
    private LocalDate registeredAt;

}
