package com.quiz.api.services;

import com.quiz.api.models.Level;
import com.quiz.api.repositories.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelService {

    private final LevelRepository levelRepository;

    @Autowired
    public LevelService(LevelRepository repository) {
        levelRepository = repository;
    }

    public Level save(Level level) {
        return levelRepository.save(level);
    }

}
