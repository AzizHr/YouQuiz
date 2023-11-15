package com.quiz.api.dtos;

import com.quiz.api.enums.ResponseType;
import com.quiz.api.models.Level;
import com.quiz.api.models.Quiz;
import com.quiz.api.models.Subject;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class QuestionDTO {

    private Integer numberOfResponses;
    private Integer numberOfCorrectResponses;
    private String content;
    private ResponseType type;
    private Integer points;

    @ManyToOne
    @JoinColumn(name = "level_id", referencedColumnName = "id")
    private Level level;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private SubjectDTO subject;

    @ManyToMany(mappedBy = "questions")
    private List<Quiz> quizzes;


}
