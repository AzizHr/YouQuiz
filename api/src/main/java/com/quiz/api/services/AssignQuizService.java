package com.quiz.api.services;

import com.quiz.api.dtos.assignQuizDTO.AssignQuizDTO;
import com.quiz.api.dtos.assignQuizDTO.AssignQuizResponseDTO;
import com.quiz.api.models.AssignQuiz;
import com.quiz.api.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AssignQuizService {

    private final AssignQuizRepository assignQuizRepository;
    private final QuizRepository quizRepository;
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public AssignQuizService(AssignQuizRepository assignQuizRepository, QuizRepository quizRepository, StudentRepository studentRepository, ModelMapper mapper) {
        this.assignQuizRepository = assignQuizRepository;
        this.quizRepository = quizRepository;
        this.studentRepository = studentRepository;
        modelMapper = mapper;
    }

    public AssignQuizResponseDTO save(AssignQuizDTO assignQuizDTO) {
        AssignQuiz assignQuiz = modelMapper.map(assignQuizDTO, AssignQuiz.class);
        assignQuiz.setQuiz(quizRepository.findById(assignQuizDTO.getQuizId()).get());
        assignQuiz.setStudent(studentRepository.findById(assignQuizDTO.getStudentId()).get());
        return modelMapper.map(assignQuizRepository.save(assignQuiz), AssignQuizResponseDTO.class);
    }

    public void delete(Integer id) {
        assignQuizRepository.deleteById(id);
    }

    public AssignQuizResponseDTO findById(Integer id) {
        AssignQuiz assignQuiz = modelMapper.map(assignQuizRepository.findById(id).get(), AssignQuiz.class);
        return modelMapper.map(assignQuiz, AssignQuizResponseDTO.class);
    }

    public AssignQuizResponseDTO update(AssignQuizDTO assignQuizDTO) {
        AssignQuiz assignQuiz = modelMapper.map(assignQuizDTO, AssignQuiz.class);
        assignQuiz.setQuiz(quizRepository.findById(assignQuizDTO.getQuizId()).get());
        assignQuiz.setStudent(studentRepository.findById(assignQuizDTO.getStudentId()).get());
        return modelMapper.map(assignQuizRepository.save(assignQuiz), AssignQuizResponseDTO.class);
    }

    public List<AssignQuizResponseDTO> findAll() {
        return Arrays.asList(modelMapper.map(assignQuizRepository.findAll(), AssignQuizResponseDTO[].class));
    }

}
