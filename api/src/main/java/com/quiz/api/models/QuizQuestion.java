package com.quiz.api.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@Entity
public class QuizQuestion {

    @Id
    @GeneratedValue
    private Integer id;
    private LocalTime duration;
    @ManyToOne
    @JoinColumn(name = "quiz_id", referencedColumnName = "id")
    private Quiz quiz;
    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Question question;

}
