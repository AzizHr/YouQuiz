package com.quiz.api.repositories;

import com.quiz.api.models.Validation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ValidationRepository extends JpaRepository<Validation, Integer> {}
