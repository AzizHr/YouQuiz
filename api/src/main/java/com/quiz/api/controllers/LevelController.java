package com.quiz.api.controllers;

import com.quiz.api.models.Level;
import com.quiz.api.models.Subject;
import com.quiz.api.services.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/levels")
public class LevelController {

    private final LevelService levelService;

    @Autowired
    public LevelController(LevelService service) {
        levelService = service;
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

}
