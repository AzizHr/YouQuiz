package com.quiz.api.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table
public class Subject  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "parent_id",referencedColumnName = "id")
    private Subject parent;
//    @JsonIgnore
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Subject> children = new ArrayList<>();
//    @JsonIgnore
    @OneToMany(mappedBy = "subject")
    private List<Question> questions;
}
