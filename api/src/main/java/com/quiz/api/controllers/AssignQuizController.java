package com.quiz.api.controllers;

import com.quiz.api.dtos.assignQuizDTO.AssignQuizDTO;
import com.quiz.api.dtos.quizQuestionDTO.QuizQuestionDTO;
import com.quiz.api.services.AssignQuizService;
import com.quiz.api.services.QuizQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/assignQuiz")
public class AssignQuizController {

    private final AssignQuizService assignQuizService;

    @Autowired
    public AssignQuizController(AssignQuizService assignQuizService) {
        this.assignQuizService = assignQuizService;
    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> save(@RequestBody AssignQuizDTO assignQuizDTO) throws Exception {

        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "AssignQuiz created");
            message.put("assignQuiz", assignQuizService.save(assignQuizDTO));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch(Exception e){
            message.put("message", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping
    public  ResponseEntity<Map<String, Object>> update(@RequestBody AssignQuizDTO assignQuizDTO) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("assignQuiz", assignQuizService.update(assignQuizDTO));
            result.put("message", "AssignQuiz updated with success!");
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
            assignQuizService.delete(id);
            result.put("message", "AssignQuiz deleted with success!");
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> assignQuiz(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            if(assignQuizService.findById(id) == null) {
                result.put("message", "AssignQuiz with id "+id+" not found!");
                return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
            }
            result.put("assignQuiz", assignQuizService.findById(id));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> assignQuizzes() throws Exception {
        Map<String, Object> message = new HashMap<>();
        try{
            if(assignQuizService.findAll().isEmpty()) {
                message.put("message", "No assignQuizzes found!");
                return new ResponseEntity<>(message, HttpStatus.OK);
            }
            message.put("message", "assignQuizzes found");
            message.put("assignQuizzes", assignQuizService.findAll());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            throw new Exception("cannot find any assignQuiz");
        }
    }

}

