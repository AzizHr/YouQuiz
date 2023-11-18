package com.quiz.api.controllers;

import com.quiz.api.dtos.levelDTO.LevelDTO;
import com.quiz.api.models.Level;
import com.quiz.api.models.Question;
import com.quiz.api.models.Subject;
import com.quiz.api.services.LevelService;
import com.quiz.api.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/levels")
public class LevelController {

    private final LevelService levelService;
    private final QuestionService questionService;

    @Autowired
    public LevelController(LevelService service1, QuestionService service2) {
        levelService = service1;
        questionService = service2;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> save(@RequestBody LevelDTO levelDTO) throws Exception {
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "level created");
            message.put("level", levelService.save(levelDTO));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch(Exception e) {
            throw new Exception("cannot create a new level");
        }
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> update(@RequestBody LevelDTO levelDTO) throws Exception {
            Map<String, Object> message = new HashMap<>();
            try{
                message.put("message", "level updated");
                message.put("level", levelService.update(levelDTO));
                return new ResponseEntity<>(message, HttpStatus.CREATED);
            }catch(Exception e){
                throw new Exception("cannot update this level");
            }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        levelService.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> level(@PathVariable Integer id) throws Exception {

        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "level found");
            message.put("levels", levelService.getLevelByID(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            throw new Exception("cannot find any level");
        }

    }

    @GetMapping("/{id}/questions")
    public ResponseEntity<Map<String, Object>> questionsByLevel(@PathVariable Integer id) throws Exception {

        Map<String, Object> message = new HashMap<>();

        try{
            if(questionService.questionsByLevelId(id).isEmpty()) {
                message.put("message", "No questions found for this level!");
                return new ResponseEntity<>(message, HttpStatus.OK);
            }
            message.put("message", "questions found");
            message.put("questions", questionService.questionsByLevelId(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            throw new Exception("cannot find any subject");
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> levels() throws Exception {
        Map<String, Object> message = new HashMap<>();
        try{
            if(levelService.findAll().isEmpty()) {
                message.put("message", "No levels found!");
                return new ResponseEntity<>(message, HttpStatus.OK);
            }
            message.put("message", "levels found");
            message.put("levels", levelService.findAll());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            throw new Exception("cannot find any level");
        }
    }

}
