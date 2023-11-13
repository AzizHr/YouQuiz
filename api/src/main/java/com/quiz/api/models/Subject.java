package com.quiz.api.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Subject implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Subject parent;

    @OneToMany(mappedBy = "parent")
    private List<Subject> children = new ArrayList<>();

    @OneToMany(mappedBy = "subject")
    private List<Question> questions;
}
