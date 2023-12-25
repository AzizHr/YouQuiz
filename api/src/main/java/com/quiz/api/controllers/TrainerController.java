package com.quiz.api.controllers;

import com.quiz.api.dtos.trainerDTO.TrainerDTO;
import com.quiz.api.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/trainers")
public class TrainerController {

    private final TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> save(@RequestBody TrainerDTO trainerDTO) throws Exception {

        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "trainer created");
            message.put("trainer", trainerService.save(trainerDTO));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch(Exception e){
            message.put("message", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping
    public  ResponseEntity<Map<String, Object>> update(@RequestBody TrainerDTO trainerDTO) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("trainer", trainerService.update(trainerDTO));
            result.put("message", "Trainer updated with success!");
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
            trainerService.delete(id);
            result.put("message", "Trainer deleted with success!");
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> trainer(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            if(trainerService.findById(id) == null) {
                result.put("message", "Trainer with id "+id+" not found!");
                return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
            }
            result.put("student", trainerService.findById(id));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> trainers() throws Exception {
        Map<String, Object> message = new HashMap<>();
        try{
            if(trainerService.findAll().isEmpty()) {
                message.put("message", "No trainers found!");
                return new ResponseEntity<>(message, HttpStatus.OK);
            }
            message.put("message", "trainers found");
            message.put("trainers", trainerService.findAll());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            throw new Exception("cannot find any trainer");
        }
    }

}

