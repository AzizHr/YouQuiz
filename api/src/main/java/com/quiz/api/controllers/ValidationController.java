package com.quiz.api.controllers;

import com.quiz.api.dtos.validationDTO.ValidationDTO;
import com.quiz.api.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/validations")
public class ValidationController {

    private final ValidationService validationService;

    @Autowired
    public ValidationController(ValidationService validationService) {
        this.validationService = validationService;
    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> save(@RequestBody ValidationDTO validationDTO) throws Exception {

        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "validation created");
            message.put("validation", validationService.save(validationDTO));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch(Exception e){
            message.put("message", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping
    public  ResponseEntity<Map<String, Object>> update(@RequestBody ValidationDTO validationDTO) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("validation", validationService.update(validationDTO));
            result.put("message", "Validation updated with success!");
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
            validationService.delete(id);
            result.put("message", "Validation deleted with success!");
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
            if(validationService.findById(id) == null) {
                result.put("message", "Validation with id "+id+" not found!");
                return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
            }
            result.put("validation", validationService.findById(id));
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
            if(validationService.findAll().isEmpty()) {
                message.put("message", "No validations found!");
                return new ResponseEntity<>(message, HttpStatus.OK);
            }
            message.put("message", "validations found");
            message.put("validations", validationService.findAll());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            throw new Exception("cannot find any validation");
        }
    }

}

