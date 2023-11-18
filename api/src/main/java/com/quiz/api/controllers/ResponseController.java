package com.quiz.api.controllers;

import com.quiz.api.dtos.responseDTO.ResponseDTO;
import com.quiz.api.models.Question;
import com.quiz.api.models.Response;
import com.quiz.api.models.Subject;
import com.quiz.api.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/responses")
public class ResponseController {

    private final ResponseService responseService;

    @Autowired
    public ResponseController(ResponseService service) {
        responseService = service;
    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> save(@RequestBody ResponseDTO responseDTO) {
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "response created");
            message.put("response", responseService.save(responseDTO));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch(Exception e){
            message.put("response", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> update(@RequestBody ResponseDTO responseDTO) {
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "response updated");
            message.put("response", responseService.update(responseDTO));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch(Exception e){
            message.put("error", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        responseService.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> response(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            if(responseService.findById(id) == null) {
                result.put("message", "Response with id "+id+" not found!");
                return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
            }
            result.put("response", responseService.findById(id));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("error", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> responses() throws Exception {
        Map<String, Object> message = new HashMap<>();
        try{
            if(responseService.findAll().isEmpty()) {
                message.put("message", "No responses found!");
                return new ResponseEntity<>(message, HttpStatus.OK);
            }
            message.put("message", "responses found");
            message.put("responses", responseService.findAll());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            throw new Exception("cannot find any response");
        }
    }

}
