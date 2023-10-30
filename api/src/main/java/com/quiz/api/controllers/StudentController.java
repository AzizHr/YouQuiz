package com.quiz.api.controllers;

import com.quiz.api.models.Student;
import com.quiz.api.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService service) {
        studentService = service;
    }

    @GetMapping
    public List<Student> students() {
        return studentService.getStudents();
    }

    @PostMapping()
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        studentService.delete(id);
        return ResponseEntity.ok("Student with ID " + id + " has been deleted.");
    }

//    @PutMapping ("/{id}")
//    public ResponseEntity<String> update(@PathVariable Integer id) {
//        studentService.delete(id);
//        return ResponseEntity.ok("Student with ID " + id + " has been deleted.");
//    }

}
