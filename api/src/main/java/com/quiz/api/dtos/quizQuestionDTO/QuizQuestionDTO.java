package com.quiz.api.dtos.quizQuestionDTO;

import com.quiz.api.models.Question;
import com.quiz.api.models.Quiz;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
public class QuizQuestionDTO {

    private Integer id;
    private LocalTime duration;
    private Integer quizId;
    private Integer questionId;

}
