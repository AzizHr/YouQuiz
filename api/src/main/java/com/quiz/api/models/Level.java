package com.quiz.api.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String description;
    private Integer maxPoints;
    private Integer minPoints;
    @OneToMany(mappedBy = "level")
    private List<Question> questions;

}
