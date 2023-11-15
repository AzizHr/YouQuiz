package com.quiz.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public abstract class User {

    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private String address;

}
