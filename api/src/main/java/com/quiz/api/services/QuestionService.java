package com.quiz.api.services;

import com.quiz.api.dtos.questionDTO.QuestionDTO;
import com.quiz.api.dtos.questionDTO.QuestionResponseDTO;
import com.quiz.api.enums.ResponseType;
import com.quiz.api.models.Question;
import com.quiz.api.repositories.LevelRepository;
import com.quiz.api.repositories.QuestionRepository;
import com.quiz.api.repositories.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;
    private final LevelRepository levelRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, ModelMapper mapper, LevelRepository levelRepository, SubjectRepository subjectRepository) {
        this.questionRepository = questionRepository;
        modelMapper = mapper;
        this.levelRepository = levelRepository;
        this.subjectRepository = subjectRepository;

    }

    public QuestionResponseDTO save(QuestionDTO questionDTO) {
        Question question = modelMapper.map(questionDTO, Question.class);
        question.setType(ResponseType.SINGLE);
        question.setLevel(levelRepository.findById(questionDTO.getLevelId()).get());
        question.setSubject(subjectRepository.findById(questionDTO.getSubjectId()).get());
        return modelMapper.map(questionRepository.save(question), QuestionResponseDTO.class);
    }

    public void delete(Integer id) {
        questionRepository.deleteById(id);
    }

    public QuestionResponseDTO findById(Integer id) {
        Question question = modelMapper.map(questionRepository.findById(id).get(), Question.class);
        return modelMapper.map(question, QuestionResponseDTO.class);
    }

    public QuestionResponseDTO update(QuestionDTO questionDTO) {
        Question question = modelMapper.map(questionDTO, Question.class);
        question.setType(ResponseType.SINGLE);
        question.setLevel(levelRepository.findById(questionDTO.getLevelId()).get());
        question.setSubject(subjectRepository.findById(questionDTO.getSubjectId()).get());
        return modelMapper.map(questionRepository.save(question), QuestionResponseDTO.class);
    }

    public List<QuestionResponseDTO> questionsByLevelId(Integer levelId) {
        return Arrays.asList(modelMapper.map(questionRepository.findAllByLevelId(levelId), QuestionResponseDTO[].class));
    }

    public List<QuestionResponseDTO> questionsBySubjectId(Integer subjectId) {
        return Arrays.asList(modelMapper.map(questionRepository.findAllBySubjectId(subjectId), QuestionResponseDTO[].class));
    }

    public List<QuestionResponseDTO> findAll() {
        return Arrays.asList(modelMapper.map(questionRepository.findAll(), QuestionResponseDTO[].class));
    }
}
