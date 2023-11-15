package com.quiz.api.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer score;
    private Boolean showResponses;
    private Boolean showResult;
    private Integer numberOfChances;
    private String remarks;
    private LocalTime duration;
    @ManyToMany()
    @JoinTable(
            name = "quiz_questions",
            joinColumns = {
                    @JoinColumn(name = "quiz_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "question_id")
            }
    )
    private List<Question> questions;

}
