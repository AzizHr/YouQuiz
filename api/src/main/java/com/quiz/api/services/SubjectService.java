package com.quiz.api.services;

import com.quiz.api.dtos.subjectDTO.SubjectDTO;
import com.quiz.api.dtos.subjectDTO.SubjectResponseDTO;
import com.quiz.api.models.Subject;
import com.quiz.api.repositories.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

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

    public SubjectResponseDTO getSubjectByID(Integer id) {
        Subject subject = modelMapper.map(subjectRepository.findById(id).get(), Subject.class);
        return modelMapper.map(subject, SubjectResponseDTO.class);
    }

    public SubjectResponseDTO update(SubjectDTO subjectDTO) {

        Subject subject = modelMapper.map(subjectDTO, Subject.class);
        subject.setParent(subjectRepository.findById(subjectDTO.getParentId()).get());
        return modelMapper.map(subjectRepository.save(subject), SubjectResponseDTO.class);

    }

    public List<SubjectResponseDTO> findAll() {
        return Arrays.asList(modelMapper.map(subjectRepository.findAll(), SubjectResponseDTO[].class));
    }


}
