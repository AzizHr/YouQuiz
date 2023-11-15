package com.quiz.api.models;

import com.quiz.api.enums.SpecialityType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Inheritance
public class Trainer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private SpecialityType speciality;

}
