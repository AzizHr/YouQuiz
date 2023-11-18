package com.quiz.api.services;

import com.quiz.api.dtos.quizQuestionDTO.QuizQuestionDTO;
import com.quiz.api.dtos.quizQuestionDTO.QuizQuestionResponseDTO;
import com.quiz.api.models.QuizQuestion;
import com.quiz.api.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class QuizQuestionService {

    private final QuizQuestionRepository quizQuestionRepository;
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public QuizQuestionService(QuizQuestionRepository quizQuestionRepository, QuizRepository quizRepository, QuestionRepository questionRepository, ModelMapper mapper) {
        this.quizQuestionRepository = quizQuestionRepository;
        this.quizRepository = quizRepository;
        this.questionRepository =questionRepository;
        modelMapper = mapper;
    }

    public QuizQuestionResponseDTO save(QuizQuestionDTO quizQuestionDTO) {
        QuizQuestion quizQuestion = modelMapper.map(quizQuestionDTO, QuizQuestion.class);
        quizQuestion.setQuestion(questionRepository.findById(quizQuestionDTO.getQuestionId()).get());
        return modelMapper.map(quizQuestionRepository.save(quizQuestion), QuizQuestionResponseDTO.class);
    }

    public void delete(Integer id) {
        quizQuestionRepository.deleteById(id);
    }

    public QuizQuestionResponseDTO findById(Integer id) {
        QuizQuestion quizQuestion = modelMapper.map(quizQuestionRepository.findById(id).get(), QuizQuestion.class);
        return modelMapper.map(quizQuestion, QuizQuestionResponseDTO.class);
    }

    public QuizQuestionResponseDTO update(QuizQuestionDTO quizQuestionDTO) {
        QuizQuestion quizQuestion = modelMapper.map(quizQuestionDTO, QuizQuestion.class);
        quizQuestion.setQuestion(questionRepository.findById(quizQuestionDTO.getQuestionId()).get());
        return modelMapper.map(quizQuestionRepository.save(quizQuestion), QuizQuestionResponseDTO.class);
    }

    public List<QuizQuestionResponseDTO> findAll() {
        return Arrays.asList(modelMapper.map(quizQuestionRepository.findAll(), QuizQuestionResponseDTO[].class));
    }

}
