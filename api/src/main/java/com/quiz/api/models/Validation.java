package com.quiz.api.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Validation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer points;
    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Question question;
    @ManyToOne
    @JoinColumn(name = "response_id", referencedColumnName = "id")
    private Response response;
    @OneToMany(mappedBy = "validation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers;
}
