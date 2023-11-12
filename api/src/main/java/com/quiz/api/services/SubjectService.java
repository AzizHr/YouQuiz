package com.quiz.api.services;

import com.quiz.api.models.Level;
import com.quiz.api.models.Subject;
import com.quiz.api.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository repository) {
        subjectRepository = repository;
    }

    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    public void delete(Integer id) {
        subjectRepository.deleteById(id);
    }

    public Subject getSubjectByID(Integer id) {
        return subjectRepository.findById(id).orElse(null);
    }

    public Subject update(Subject subject) {

        Subject subject1 = getSubjectByID(subject.getId());
        subject1.setTitle(subject.getTitle());
        subject1.setParent(subject.getParent());

        return subjectRepository.save(subject1);

    }

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }
}
