package com.quiz.api.services;

import com.quiz.api.dtos.validationDTO.ValidationResponseDTO;
import com.quiz.api.repositories.ValidationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ValidationService {

    private final ValidationRepository validationRepository;
    private final ModelMapper modelMapper;

    public ValidationService(ValidationRepository validationRepository, ModelMapper modelMapper) {
        this.validationRepository = validationRepository;
        this.modelMapper = modelMapper;
    }




    public List<ValidationResponseDTO> getAll() {
        return Arrays.asList(modelMapper.map(validationRepository.findAll(), ValidationResponseDTO.class));
    }

}
