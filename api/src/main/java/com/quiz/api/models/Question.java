package com.quiz.api.models;

import enums.ResponseType;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Data
@Entity
@Table
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer numberOfResponses;
    private Integer numberOfCorrectResponses;
    private String content;
    @Enumerated(EnumType.STRING)
    private ResponseType type;
    private Integer points;
    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

}
