package com.quiz.api.controllers;

import com.quiz.api.dtos.subjectDTO.SubjectDTO;
import com.quiz.api.services.QuestionService;
import com.quiz.api.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;
    private final QuestionService questionService;

    @Autowired
    public SubjectController(SubjectService service1, QuestionService service2) {
        subjectService = service1;
        questionService = service2;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> save(@RequestBody SubjectDTO subjectDTO) throws Exception {
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "subject created");
            message.put("subject", subjectService.save(subjectDTO));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch(Exception e){
            throw new Exception("cannot create a new subject");
        }
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> update(@RequestBody SubjectDTO subjectDTO) throws Exception {
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "subject updated");
            message.put("subject", subjectService.update(subjectDTO));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch(Exception e){
            throw new Exception("cannot update this subject");
        }
    }

    @DeleteMapping("/{id}")

    public String delete(@PathVariable Integer id) {
        subjectService.delete(id);
        return "Subject with ID " + id + " has been deleted.";
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Map<String, Object>> subject(@PathVariable Integer id) throws Exception {

        Map<String, Object> message = new HashMap<>();

        try{
            message.put("message", "subjects found");
            message.put("subject", subjectService.getSubjectByID(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            throw new Exception("cannot find any subject");
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> subjects() throws Exception {
        Map<String, Object> message = new HashMap<>();
        try{
            if(subjectService.findAll().isEmpty()) {
                message.put("message", "No subjects found!");
                return new ResponseEntity<>(message, HttpStatus.OK);
            }
            message.put("message", "subjects found");
            message.put("subjects", subjectService.findAll());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            throw new Exception("cannot find any subject");
        }
    }

    @GetMapping("/{id}/questions")
    public ResponseEntity<Map<String, Object>> getQuestionsByID(@PathVariable Integer id) throws Exception {

        Map<String, Object> message = new HashMap<>();

        try{
            if(questionService.questionsBySubjectId(id).isEmpty()) {
                message.put("message", "No questions found for this subject!");
                return new ResponseEntity<>(message, HttpStatus.OK);
            }
            message.put("message", "questions found");
            message.put("questions", questionService.questionsByLevelId(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            throw new Exception("cannot find any question");
        }

    }
}
