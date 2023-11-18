package com.quiz.api.dtos.trainerDTO;

import com.quiz.api.dtos.quizDTO.QuizDTO;
import com.quiz.api.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TrainerResponseDTO extends User {

    private Integer id;
    private String speciality;
    private List<QuizDTO> quizzes;

}
