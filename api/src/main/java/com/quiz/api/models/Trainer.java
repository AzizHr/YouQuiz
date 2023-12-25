package com.quiz.api.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@Inheritance
@Entity
public class Trainer extends User {

    @Id
    @GeneratedValue
    private Integer id;
    private String speciality;
    @OneToMany(mappedBy = "trainer", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Quiz> quizzes;

}
