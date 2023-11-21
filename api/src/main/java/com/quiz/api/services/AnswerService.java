package com.quiz.api.services;

import com.quiz.api.dtos.answerDTO.AnswerDTO;
import com.quiz.api.dtos.answerDTO.AnswerResponseDTO;
import com.quiz.api.models.Answer;
import com.quiz.api.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final ValidationRepository validationRepository;
    private final AssignQuizRepository assignQuizRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public AnswerService(AnswerRepository answerRepository, ValidationRepository validationRepository, AssignQuizRepository assignQuizRepository, ModelMapper mapper) {
        this.answerRepository = answerRepository;
        this.validationRepository = validationRepository;
        this.assignQuizRepository = assignQuizRepository;
        modelMapper = mapper;
    }

    public AnswerResponseDTO save(AnswerDTO answerDTO) {
        Answer answer = modelMapper.map(answerDTO, Answer.class);
        answer.setAssignQuiz(assignQuizRepository.findById(answerDTO.getAssignQuizId()).get());
        answer.setValidation(validationRepository.findById(answerDTO.getValidationId()).get());
        return modelMapper.map(answerRepository.save(answer), AnswerResponseDTO.class);
    }

    public void delete(Integer id) {
        validationRepository.deleteById(id);
    }

    public AnswerResponseDTO findById(Integer id) {
        Answer answer = modelMapper.map(answerRepository.findById(id).get(), Answer.class);
        return modelMapper.map(answer, AnswerResponseDTO.class);
    }

    public AnswerResponseDTO update(AnswerDTO answerDTO) {
        Answer answer = modelMapper.map(answerDTO, Answer.class);
        answer.setAssignQuiz(assignQuizRepository.findById(answerDTO.getAssignQuizId()).get());
        answer.setValidation(validationRepository.findById(answerDTO.getValidationId()).get());
        return modelMapper.map(answerRepository.save(answer), AnswerResponseDTO.class);
    }

    public List<AnswerResponseDTO> findAll() {
        return Arrays.asList(modelMapper.map(answerRepository.findAll(), AnswerResponseDTO[].class));
    }


}
