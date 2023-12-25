package com.quiz.api.controllers;

import com.quiz.api.dtos.quizQuestionDTO.QuizQuestionDTO;
import com.quiz.api.services.QuizQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/quizQuestion")
public class QuizQuestionController {

    private final QuizQuestionService quizQuestionService;

    @Autowired
    public QuizQuestionController(QuizQuestionService quizQuestionService) {
        this.quizQuestionService = quizQuestionService;
    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> save(@RequestBody QuizQuestionDTO quizQuestionDTO) throws Exception {

        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "QuizQuestion created");
            message.put("quizQuestion", quizQuestionService.save(quizQuestionDTO));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch(Exception e){
            message.put("message", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping
    public  ResponseEntity<Map<String, Object>> update(@RequestBody QuizQuestionDTO quizQuestionDTO) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("quizQuestion", quizQuestionService.update(quizQuestionDTO));
            result.put("message", "QuizQuestion updated with success!");
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
            quizQuestionService.delete(id);
            result.put("message", "QuizQuestion deleted with success!");
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> quizQuestion(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            if(quizQuestionService.findById(id) == null) {
                result.put("message", "QuizQuestion with id "+id+" not found!");
                return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
            }
            result.put("quizQuestion", quizQuestionService.findById(id));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> quizQuestions() throws Exception {
        Map<String, Object> message = new HashMap<>();
        try{
            if(quizQuestionService.findAll().isEmpty()) {
                message.put("message", "No QuizQuestions found!");
                return new ResponseEntity<>(message, HttpStatus.OK);
            }
            message.put("message", "quizQuestions found");
            message.put("quizQuestions", quizQuestionService.findAll());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            throw new Exception("cannot find any quizQuestion");
        }
    }

}

