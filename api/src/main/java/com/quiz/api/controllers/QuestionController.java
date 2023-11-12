package com.quiz.api.controllers;

import com.quiz.api.models.Level;
import com.quiz.api.models.Question;
import com.quiz.api.models.Subject;
import com.quiz.api.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService service) {
        questionService = service;
    }

    @PostMapping()
    public Question save(@RequestBody Question question) {
        return questionService.save(question);
    }

    @PutMapping
    public Question update(@RequestBody Question question) {
        return questionService.update(question);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        questionService.delete(id);
    }

    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable Integer id) {
        return questionService.findById(id);
    }

    @GetMapping()
    public List<Question> questions() {
        return questionService.findAll();
    }
}
