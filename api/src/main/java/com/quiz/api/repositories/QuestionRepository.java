package com.quiz.api.repositories;

import com.quiz.api.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    @Query("SELECT Q FROM Question Q WHERE Q.subject.id = :subjectId")
    List<Question> findAllBySubjectId(Integer subjectId);

    @Query("SELECT Q FROM Question Q WHERE Q.level.id = :levelId")
    List<Question> findAllByLevelId(Integer levelId);
}
