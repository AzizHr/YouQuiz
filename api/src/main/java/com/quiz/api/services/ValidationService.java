package com.quiz.api.services;

import com.quiz.api.dtos.trainerDTO.TrainerResponseDTO;
import com.quiz.api.dtos.validationDTO.ValidationDTO;
import com.quiz.api.dtos.validationDTO.ValidationResponseDTO;
import com.quiz.api.models.Validation;
import com.quiz.api.repositories.QuestionRepository;
import com.quiz.api.repositories.ResponseRepository;
import com.quiz.api.repositories.ValidationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ValidationService {

    private final ValidationRepository validationRepository;
    private final QuestionRepository questionRepository;
    private final ResponseRepository responseRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public ValidationService(ValidationRepository validationRepository, QuestionRepository questionRepository, ResponseRepository responseRepository, ModelMapper mapper) {
        this.validationRepository = validationRepository;
        this.questionRepository = questionRepository;
        this.responseRepository = responseRepository;
        modelMapper = mapper;
    }

    public ValidationResponseDTO save(ValidationDTO validationDTO) {
        Validation validation = modelMapper.map(validationDTO, Validation.class);
        validation.setQuestion(questionRepository.findById(validationDTO.getQuestionId()).get());
        validation.setResponse(responseRepository.findById(validationDTO.getResponseId()).get());
        return modelMapper.map(validationRepository.save(validation), ValidationResponseDTO.class);
    }

    public void delete(Integer id) {
        validationRepository.deleteById(id);
    }

    public TrainerResponseDTO findById(Integer id) {
        Validation validation = modelMapper.map(validationRepository.findById(id).get(), Validation.class);
        return modelMapper.map(validation, TrainerResponseDTO.class);
    }

    public ValidationResponseDTO update(ValidationDTO validationDTO) {
        Validation validation = modelMapper.map(validationDTO, Validation.class);
        validation.setQuestion(questionRepository.findById(validationDTO.getQuestionId()).get());
        validation.setResponse(responseRepository.findById(validationDTO.getResponseId()).get());
        return modelMapper.map(validationRepository.save(validation), ValidationResponseDTO.class);
    }

    public List<ValidationResponseDTO> findAll() {
        return Arrays.asList(modelMapper.map(validationRepository.findAll(), ValidationResponseDTO[].class));
    }


}
