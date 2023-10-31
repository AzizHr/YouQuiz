package com.quiz.api.models;

import jakarta.persistence.*;

public class Validation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer points;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
    @ManyToOne
    @JoinColumn(name = "response_id")
    private Response response;
}
