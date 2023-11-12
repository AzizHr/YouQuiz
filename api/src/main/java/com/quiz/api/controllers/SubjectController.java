package com.quiz.api.controllers;

import com.quiz.api.models.Subject;
import com.quiz.api.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        subjectService.delete(id);
        return "Subject with ID " + id + " has been deleted.";
    }

    @GetMapping("/{id}")
    public Subject getByID(@PathVariable Integer id) {

        return subjectService.getSubjectByID(id);
    }
}
