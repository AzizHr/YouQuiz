package com.quiz.api.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table
public class Response {

    @Id
    @GeneratedValue
    private Integer id;
    private String content;

}
