package com.quiz.api.controllers;

import com.quiz.api.models.Student;
import com.quiz.api.models.Subject;
import com.quiz.api.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService service) {
        subjectService = service;
    }

    @PostMapping
    public Subject save(@RequestBody Subject subject) {
        return subjectService.save(subject);
    }
}
