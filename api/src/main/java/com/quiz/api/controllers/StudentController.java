package com.quiz.api.controllers;

import com.quiz.api.dtos.studentDTO.StudentDTO;
import com.quiz.api.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> save(@RequestBody StudentDTO studentDTO) throws Exception {

        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "student created");
            message.put("student", studentService.save(studentDTO));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch(Exception e){
            message.put("message", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping
    public  ResponseEntity<Map<String, Object>> update(@RequestBody StudentDTO studentDTO) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("student", studentService.update(studentDTO));
            result.put("message", "Student updated with success!");
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
            studentService.delete(id);
            result.put("message", "Student deleted with success!");
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> student(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            if(studentService.findById(id) == null) {
                result.put("message", "Student with id "+id+" not found!");
                return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
            }
            result.put("student", studentService.findById(id));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> students() throws Exception {
        Map<String, Object> message = new HashMap<>();
        try{
            if(studentService.findAll().isEmpty()) {
                message.put("message", "No students found!");
                return new ResponseEntity<>(message, HttpStatus.OK);
            }
            message.put("message", "students found");
            message.put("medias", studentService.findAll());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            throw new Exception("cannot find any student");
        }
    }

}
