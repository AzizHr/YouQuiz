package com.quiz.api.controllers;

import com.quiz.api.models.Level;
import com.quiz.api.services.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
