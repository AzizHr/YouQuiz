package com.quiz.api.services;

import com.quiz.api.dtos.quizDTO.QuizDTO;
import com.quiz.api.dtos.quizDTO.QuizResponseDTO;
import com.quiz.api.models.Quiz;
import com.quiz.api.repositories.QuizRepository;
import com.quiz.api.repositories.TrainerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final TrainerRepository trainerRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public QuizService(QuizRepository quizRepository, TrainerRepository trainerRepository, ModelMapper mapper) {
        this.quizRepository = quizRepository;
        this.trainerRepository = trainerRepository;
        modelMapper = mapper;
    }

    public QuizResponseDTO save(QuizDTO quizDTO) {
        Quiz quiz = modelMapper.map(quizDTO, Quiz.class);
        quiz.setTrainer(trainerRepository.findById(quizDTO.getTrainerId()).get());
        return modelMapper.map(quizRepository.save(quiz), QuizResponseDTO.class);
    }

    public void delete(Integer id) {
        quizRepository.deleteById(id);
    }

    public QuizResponseDTO findById(Integer id) {
        Quiz quiz = modelMapper.map(quizRepository.findById(id).get(), Quiz.class);
        return modelMapper.map(quiz, QuizResponseDTO.class);
    }

    public QuizResponseDTO update(QuizDTO quizDTO) {
        Quiz quiz = modelMapper.map(quizDTO, Quiz.class);
        quiz.setTrainer(trainerRepository.findById(quizDTO.getTrainerId()).get());
        return modelMapper.map(quizRepository.save(quiz), QuizResponseDTO.class);
    }

    public List<QuizResponseDTO> findAll() {
        return Arrays.asList(modelMapper.map(quizRepository.findAll(), QuizResponseDTO[].class));
    }

}
