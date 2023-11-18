package com.quiz.api.dtos.quizDTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class QuizDTO {

    private Integer id;
    private Integer score;
    private Boolean showResponses;
    private Boolean showResult;
    private Integer numberOfChances;
    private String remarks;
    private LocalTime duration;
    private Integer trainerId;

}
