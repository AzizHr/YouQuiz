package com.quiz.api.controllers;

import com.quiz.api.dtos.subjectDTO.SubjectDTO;
import com.quiz.api.dtos.subjectDTO.SubjectResponseDTO;
import com.quiz.api.services.QuestionService;
import com.quiz.api.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
            message.put("message", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Integer id) {
        Map<String, Object> message = new HashMap<>();
        subjectService.delete(id);
        message.put("message", "deleted with success");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Map<String, Object>> subject(@PathVariable Integer id) throws Exception {

        Map<String, Object> message = new HashMap<>();

        try{
            message.put("subject", subjectService.getSubjectByID(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            message.put("message", "No subject found with id of "+id);
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping()
//    public ResponseEntity<Map<String, Object>> subjects(@RequestParam int page, @RequestParam int items) throws Exception {
//        Map<String, Object> message = new HashMap<>();
//        try{
//            if(subjectService.findAll(page, items).isEmpty()) {
//                message.put("message", "No subjects found!");
//                return new ResponseEntity<>(message, HttpStatus.OK);
//            }
//            message.put("message", "subjects found");
//            message.put("subjects", subjectService.findAll(page, items));
//            return new ResponseEntity<>(message, HttpStatus.OK);
//        }catch(Exception e){
//            message.put("message", e.getMessage());
//            return new ResponseEntity<>(message, HttpStatus.OK);
//        }
//    }

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
            message.put("message", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }

    }

//    @GetMapping()
//    public ResponseEntity<List<SubjectResponseDTO>> subjects() {
//        return new ResponseEntity<>(subjectService.findAll(), HttpStatus.OK);
//    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> subjects() {
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
            message.put("message", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }
}
