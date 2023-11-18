package com.quiz.api.services;

import com.quiz.api.dtos.trainerDTO.TrainerDTO;
import com.quiz.api.dtos.trainerDTO.TrainerResponseDTO;
import com.quiz.api.models.Trainer;
import com.quiz.api.repositories.TrainerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public TrainerService(TrainerRepository trainerRepository, ModelMapper mapper) {
        this.trainerRepository = trainerRepository;
        modelMapper = mapper;
    }

    public TrainerResponseDTO save(TrainerDTO trainerDTO) {
        Trainer trainer = modelMapper.map(trainerDTO, Trainer.class);
        return modelMapper.map(trainerRepository.save(trainer), TrainerResponseDTO.class);
    }

    public void delete(Integer id) {
        trainerRepository.deleteById(id);
    }

    public TrainerResponseDTO findById(Integer id) {
        Trainer trainer = modelMapper.map(trainerRepository.findById(id).get(), Trainer.class);
        return modelMapper.map(trainer, TrainerResponseDTO.class);
    }

    public TrainerResponseDTO update(TrainerDTO trainerDTO) {
        Trainer trainer = modelMapper.map(trainerDTO, Trainer.class);
        return modelMapper.map(trainerRepository.save(trainer), TrainerResponseDTO.class);
    }

    public List<TrainerResponseDTO> findAll() {
        return Arrays.asList(modelMapper.map(trainerRepository.findAll(), TrainerResponseDTO[].class));
    }


}

