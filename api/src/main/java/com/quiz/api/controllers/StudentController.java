package com.quiz.api.controllers;

import com.quiz.api.models.Student;
import com.quiz.api.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService service) {
        studentService = service;
    }

    @GetMapping("/api/students")
    public List<Student> students() {
        return studentService.getStudents();
    }

}
