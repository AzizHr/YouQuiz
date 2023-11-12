package com.quiz.api.services;

import com.quiz.api.models.Question;
import com.quiz.api.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository repository) {
        questionRepository = repository;
    }

    public Question save(Question question) {
        return questionRepository.save(question);
    }

    public void delete(Integer id) {
        questionRepository.deleteById(id);
    }

    public Question findById(Integer id) {
        return questionRepository.findById(id).orElse(null);
    }
}
