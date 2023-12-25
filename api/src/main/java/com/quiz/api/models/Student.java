package com.quiz.api.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@Inheritance
@Entity
public class Student extends User {

    @Id
    @GeneratedValue
    private Integer id;
    private LocalDate registeredAt;
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<AssignQuiz> quizzes;

}
