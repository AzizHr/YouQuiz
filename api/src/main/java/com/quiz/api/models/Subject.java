package com.quiz.api.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Subject {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "id", nullable = true)
    private Subject parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Subject> children;

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Question> questions;


}
