package com.quiz.api.repositories;

import com.quiz.api.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findAllBySubjectId(Integer subjectId);

    List<Question> findAllByLevelId(Integer levelId);
}
