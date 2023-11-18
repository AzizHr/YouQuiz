package com.quiz.api.services;

import com.quiz.api.dtos.studentDTO.StudentDTO;
import com.quiz.api.dtos.studentDTO.StudentResponseDTO;
import com.quiz.api.dtos.trainerDTO.TrainerResponseDTO;
import com.quiz.api.models.Student;
import com.quiz.api.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public StudentService(StudentRepository studentRepository, ModelMapper mapper) {
        this.studentRepository = studentRepository;
        modelMapper = mapper;
    }

    public StudentResponseDTO save(StudentDTO studentDTO) {
        Student student = modelMapper.map(studentDTO, Student.class);
        return modelMapper.map(studentRepository.save(student), StudentResponseDTO.class);
    }

    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    public StudentResponseDTO findById(Integer id) {
        Student student = modelMapper.map(studentRepository.findById(id).get(), Student.class);
        return modelMapper.map(student, StudentResponseDTO.class);
    }

    public StudentResponseDTO update(StudentDTO studentDTO) {
        Student student = modelMapper.map(studentDTO, Student.class);
        return modelMapper.map(studentRepository.save(student), StudentResponseDTO.class);
    }

    public List<StudentResponseDTO> findAll() {
        return Arrays.asList(modelMapper.map(studentRepository.findAll(), StudentResponseDTO[].class));
    }

}
