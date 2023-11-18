package com.quiz.api.dtos.studentDTO;

import com.quiz.api.dtos.assignQuizDTO.AssignQuizDTO;
import com.quiz.api.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class StudentResponseDTO extends User {

    private Integer id;
    private LocalDate registeredAt;
    private List<AssignQuizDTO> quizzes;

}
