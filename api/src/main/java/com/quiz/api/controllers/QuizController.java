package com.quiz.api.controllers;

import com.quiz.api.dtos.quizDTO.QuizDTO;
import com.quiz.api.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> save(@RequestBody QuizDTO quizDTO) throws Exception {

        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "Quiz created");
            message.put("quiz", quizService.save(quizDTO));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch(Exception e){
            message.put("message", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping
    public  ResponseEntity<Map<String, Object>> update(@RequestBody QuizDTO quizDTO) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("quiz", quizService.update(quizDTO));
            result.put("message", "Quiz updated with success!");
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
            quizService.delete(id);
            result.put("message", "Quiz deleted with success!");
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> quiz(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            if(quizService.findById(id) == null) {
                result.put("message", "Quiz with id "+id+" not found!");
                return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
            }
            result.put("quiz", quizService.findById(id));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> quizzes() throws Exception {
        Map<String, Object> message = new HashMap<>();
        try{
            if(quizService.findAll().isEmpty()) {
                message.put("message", "No quizzes found!");
                return new ResponseEntity<>(message, HttpStatus.OK);
            }
            message.put("message", "quizzes found");
            message.put("quizzes", quizService.findAll());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            throw new Exception("cannot find any quiz");
        }
    }

}

