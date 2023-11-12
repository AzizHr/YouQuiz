package com.quiz.api.controllers;

import com.quiz.api.models.Question;
import com.quiz.api.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        questionService.delete(id);
    }

}
