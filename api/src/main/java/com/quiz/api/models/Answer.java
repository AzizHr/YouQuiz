package com.quiz.api.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Answer {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "assignQuiz_id", referencedColumnName = "id")
    private AssignQuiz assignQuiz;
    @ManyToOne
    @JoinColumn(name = "validation_id", referencedColumnName = "id")
    private Validation validation;

}
