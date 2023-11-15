package com.quiz.api.services;

import com.quiz.api.dtos.SubjectDTO;
import com.quiz.api.dtos.SubjectResponseDTO;
import com.quiz.api.models.Level;
import com.quiz.api.models.Subject;
import com.quiz.api.repositories.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SubjectService(SubjectRepository repository, ModelMapper mapper) {
        subjectRepository = repository;
        modelMapper = mapper;
    }

    public SubjectResponseDTO save(SubjectDTO subjectDTO) {
        Subject subject = modelMapper.map(subjectDTO, Subject.class);
        subject.setParent(subjectRepository.findById(subjectDTO.getParentId()).get());
        return modelMapper.map(subjectRepository.save(subject), SubjectResponseDTO.class);
    }

    public void delete(Integer id) {
        subjectRepository.deleteById(id);
    }

    public Subject getSubjectByID(Integer id) {
        Subject subject = subjectRepository.findById(id).orElse(null);
//        List<Subject> children = subjectRepository.findAllByParentId(subject.getId());
//        subject.setChildren(children);
        return subject;
    }

    public Subject update(Subject subject) {

        Subject subject1 = getSubjectByID(subject.getId());
        subject1.setTitle(subject.getTitle());
        subject1.setParent(subject.getParent());

        return subjectRepository.save(subject1);

    }

    public List<SubjectResponseDTO> findAll() {
        return Arrays.asList(modelMapper.map(subjectRepository.findAll(), SubjectResponseDTO[].class));
    }



}
