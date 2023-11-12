package com.quiz.api.services;

import com.quiz.api.models.Level;
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

    public Question update(Question question) {
        Question question1 = findById(question.getId());
        question1.setContent(question.getContent());
        question1.setLevel(question.getLevel());
        question1.setPoints(question.getPoints());
        question1.setType(question.getType());
        question1.setNumberOfCorrectResponses(question.getNumberOfCorrectResponses());
        question1.setNumberOfResponses(question.getNumberOfResponses());
        question1.setSubject(question.getSubject());

        return questionRepository.save(question1);
    }
}
