package com.quiz.api.repositories;

import com.quiz.api.models.AssignQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignQuizRepository extends JpaRepository<AssignQuiz, Integer> {}
