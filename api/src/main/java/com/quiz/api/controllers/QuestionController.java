package com.quiz.api.controllers;

import com.quiz.api.models.Level;
import com.quiz.api.models.Question;
import com.quiz.api.models.Subject;
import com.quiz.api.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService service) {
        questionService = service;
    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> save(@RequestBody Question question) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("question", questionService.save(question));
            result.put("message", "Question added with success!");
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping
    public  ResponseEntity<Map<String, Object>> update(@RequestBody Question question) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("question", questionService.save(question));
            result.put("message", "Question updated with success!");
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            questionService.delete(id);
            result.put("message", "Question deleted with success!");
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getQuestion(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            if(questionService.findById(id) == null) {
                result.put("message", "Question with id "+id+" not found!");
                return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
            }
            result.put("question", questionService.findById(id));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> questions() {
        Map<String, Object> result = new HashMap<>();
        try {
            if(questionService.findAll() == null) {
                result.put("message", "No questions found!");
                return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
            }
            result.put("questions", questionService.findAll());
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
