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
    @GeneratedValue
    private Integer id;
    private String description;
    private Integer maxPoints;
    private Integer minPoints;
    @OneToMany(mappedBy = "level", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Question> questions;

}
