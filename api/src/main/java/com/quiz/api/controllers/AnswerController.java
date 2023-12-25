package com.quiz.api.controllers;

import com.quiz.api.dtos.answerDTO.AnswerDTO;
import com.quiz.api.dtos.validationDTO.ValidationDTO;
import com.quiz.api.services.AnswerService;
import com.quiz.api.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/answers")
public class AnswerController {

    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> save(@RequestBody AnswerDTO answerDTO) throws Exception {

        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "answer created");
            message.put("answer", answerService.save(answerDTO));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch(Exception e){
            message.put("message", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping
    public  ResponseEntity<Map<String, Object>> update(@RequestBody AnswerDTO answerDTO) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("answer", answerService.update(answerDTO));
            result.put("message", "Answer updated with success!");
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
            answerService.delete(id);
            result.put("message", "Answer deleted with success!");
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> validation(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            if(answerService.findById(id) == null) {
                result.put("message", "Answer with id "+id+" not found!");
                return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
            }
            result.put("answer", answerService.findById(id));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> validations() throws Exception {
        Map<String, Object> message = new HashMap<>();
        try{
            if(answerService.findAll().isEmpty()) {
                message.put("message", "No answers found!");
                return new ResponseEntity<>(message, HttpStatus.OK);
            }
            message.put("message", "answers found");
            message.put("answers", answerService.findAll());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            throw new Exception("cannot find any answer");
        }
    }

}

