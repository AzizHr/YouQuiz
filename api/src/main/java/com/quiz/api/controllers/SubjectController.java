package com.quiz.api.controllers;

import com.quiz.api.models.Question;
import com.quiz.api.models.Subject;
import com.quiz.api.services.QuestionService;
import com.quiz.api.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;
    private final QuestionService questionService;

    @Autowired
    public SubjectController(SubjectService service1, QuestionService service2) {
        subjectService = service1;
        questionService = service2;
    }

    @PostMapping
    public Subject save(@RequestBody Subject subject) {
        return subjectService.save(subject);
    }

    @PutMapping
    public Subject update(@RequestBody Subject subject) {
        return subjectService.update(subject);
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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Subject> subjects() {
        return subjectService.findAll();
    }

    @GetMapping("/{id}/questions")
    public List<Question> getQuestionsByID(@PathVariable Integer id) {

        return questionService.questionsBySubjectId(id);

    }
}
