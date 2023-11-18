package com.quiz.api.models;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class User {

    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private String address;

}
