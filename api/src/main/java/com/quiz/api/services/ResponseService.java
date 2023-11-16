package com.quiz.api.services;

import com.quiz.api.dtos.questionDTO.QuestionResponseDTO;
import com.quiz.api.dtos.responseDTO.ResponseDTO;
import com.quiz.api.dtos.subjectDTO.SubjectResponseDTO;
import com.quiz.api.models.Level;
import com.quiz.api.models.Question;
import com.quiz.api.models.Response;
import com.quiz.api.models.Subject;
import com.quiz.api.repositories.ResponseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ResponseService {

    private final ResponseRepository responseRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ResponseService(ResponseRepository repository, ModelMapper modelMapper) {
        responseRepository = repository;
        this.modelMapper = modelMapper;
    }

    public ResponseDTO save(ResponseDTO responseDTO) {
        Response response = modelMapper.map(responseDTO, Response.class);
        return modelMapper.map(responseRepository.save(response), ResponseDTO.class);
    }

    public void delete(Integer id) {
        responseRepository.deleteById(id);
    }

    public ResponseDTO findById(Integer id) {
        Response response = responseRepository.findById(id).get();
        return modelMapper.map(response, ResponseDTO.class);
    }

    public ResponseDTO update(ResponseDTO responseDTO) {
        Response response = modelMapper.map(responseDTO, Response.class);
        return modelMapper.map(responseRepository.save(response), ResponseDTO.class);
    }

    public List<ResponseDTO> findAll() {
        return Arrays.asList(modelMapper.map(responseRepository.findAll(), ResponseDTO[].class));
    }
}
