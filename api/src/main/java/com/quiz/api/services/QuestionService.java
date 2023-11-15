package com.quiz.api.services;

import com.quiz.api.dtos.QuestionDTO;
import com.quiz.api.dtos.QuestionResponseDTO;
import com.quiz.api.dtos.SubjectResponseDTO;
import com.quiz.api.models.Level;
import com.quiz.api.models.Question;
import com.quiz.api.models.Subject;
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
        question.setType();
        question.setLevel(levelRepository.findById(questionDTO.getLevelId()).get());
        question.setSubject(subjectRepository.findById(questionDTO.getSubjectId()).get());
        return modelMapper.map(questionRepository.save(question), QuestionResponseDTO.class);
    }

    public void delete(Integer id) {
        questionRepository.deleteById(id);
    }

    public Question findById(Integer id) {
        return questionRepository.findById(id).orElse(null);
    }

    public Question update(Question question) {
        Question question1 = findById(question.getId());
        question1.setContent(question.getContent());
        question1.setLevel(question.getLevel());
        question1.setPoints(question.getPoints());
        question1.setType(question.getType());
        question1.setNumberOfCorrectResponses(question.getNumberOfCorrectResponses());
        question1.setNumberOfResponses(question.getNumberOfResponses());
        question1.setSubject(question.getSubject());

        return questionRepository.save(question1);
    }

    public List<Question> questionsByLevelId(Integer levelId) {
        return questionRepository.findAllByLevelId(levelId);
    }

    public List<Question> questionsBySubjectId(Integer subjectId) {
        return questionRepository.findAllBySubjectId(subjectId);
    }

    public List<QuestionResponseDTO> findAll() {
        return Arrays.asList(modelMapper.map(questionRepository.findAll(), QuestionResponseDTO[].class));
    }
}
