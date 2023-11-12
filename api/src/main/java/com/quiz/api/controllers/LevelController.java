package com.quiz.api.controllers;

import com.quiz.api.models.Level;
import com.quiz.api.models.Question;
import com.quiz.api.models.Subject;
import com.quiz.api.services.LevelService;
import com.quiz.api.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Level save(@RequestBody Level level) {
        return levelService.save(level);
    }

    @PutMapping
    public Level update(@RequestBody Level level) {
        return levelService.update(level);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        levelService.delete(id);
    }

    @GetMapping("/{id}")
    public Level getByID(@PathVariable Integer id) {

        return levelService.getLevelByID(id);

    }

    @GetMapping("/{id}/questions")
    public List<Question> getQuestionsByID(@PathVariable Integer id) {

        return questionService.questionsBySubjectId(id);

    }

    @GetMapping()
    public List<Level> levels() {
        return levelService.findAll();
    }

}
