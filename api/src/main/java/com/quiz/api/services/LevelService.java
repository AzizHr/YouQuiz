package com.quiz.api.services;

import com.quiz.api.dtos.levelDTO.LevelDTO;
import com.quiz.api.dtos.levelDTO.LevelResponseDTO;
import com.quiz.api.dtos.subjectDTO.SubjectResponseDTO;
import com.quiz.api.models.Level;
import com.quiz.api.models.Subject;
import com.quiz.api.repositories.LevelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LevelService {

    private final LevelRepository levelRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public LevelService(LevelRepository repository, ModelMapper modelMapper) {
        levelRepository = repository;
        this.modelMapper = modelMapper;
    }

    public LevelResponseDTO save(LevelDTO levelDTO) {
        Level level = modelMapper.map(levelDTO, Level.class);
        return modelMapper.map(levelRepository.save(level), LevelResponseDTO.class);
    }

    public void delete(Integer id) {
        levelRepository.deleteById(id);
    }

    public LevelResponseDTO getLevelByID(Integer id) {
        Level level = modelMapper.map(levelRepository.findById(id).get(), Level.class);
        return modelMapper.map(level, LevelResponseDTO.class);
    }

    public LevelResponseDTO update(LevelDTO levelDTO) {
        Level level = modelMapper.map(levelDTO, Level.class);
        return modelMapper.map(levelRepository.save(level), LevelResponseDTO.class);
    }

    public List<LevelResponseDTO> findAll() {
        return Arrays.asList(modelMapper.map(levelRepository.findAll(), LevelResponseDTO[].class));

    }
}
