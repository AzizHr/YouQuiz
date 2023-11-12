package com.quiz.api.services;

import com.quiz.api.models.Level;
import com.quiz.api.models.Subject;
import com.quiz.api.repositories.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void delete(Integer id) {
        levelRepository.deleteById(id);
    }

    public Level getLevelByID(Integer id) {
        return levelRepository.findById(id).orElse(null);
    }

    public Level update(Level level) {
        Level level1 = getLevelByID(level.getId());
        level1.setDescription(level.getDescription());
        level1.setMaxPoints(level.getMaxPoints());
        level1.setMinPoints(level.getMinPoints());

        return levelRepository.save(level1);
    }
}
