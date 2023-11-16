package com.quiz.api.services;

import com.quiz.api.dtos.mediaDTO.MediaDTO;
import com.quiz.api.dtos.mediaDTO.MediaResponseDTO;
import com.quiz.api.models.Media;
import com.quiz.api.repositories.MediaRepository;
import com.quiz.api.repositories.QuestionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class MediaService {

    private final MediaRepository mediaRepository;
    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MediaService(MediaRepository mediaRepository, QuestionRepository questionRepository, ModelMapper modelMapper) {
        this.mediaRepository = mediaRepository;
        this.questionRepository = questionRepository;
        this.modelMapper = modelMapper;
    }

    public MediaResponseDTO save(MediaDTO mediaDTO) {
        Media media = modelMapper.map(mediaDTO, Media.class);
        media.setQuestion(questionRepository.findById(mediaDTO.getQuestionId()).get());
        return modelMapper.map(mediaRepository.save(media), MediaResponseDTO.class);
    }

    public void delete(Integer id) {
        questionRepository.deleteById(id);
    }

    public MediaResponseDTO getMediaById(Integer id) {
        Media media = modelMapper.map(mediaRepository.findById(id).get(), Media.class);
        return modelMapper.map(media, MediaResponseDTO.class);
    }

    public MediaResponseDTO update(MediaDTO mediaDTO) {
        Media media = modelMapper.map(mediaDTO, Media.class);
        media.setQuestion(questionRepository.findById(mediaDTO.getQuestionId()).get());
        return modelMapper.map(mediaRepository.save(media), MediaResponseDTO.class);
    }


    public List<MediaResponseDTO> findAll() {
        return Arrays.asList(modelMapper.map(mediaRepository.findAll(), MediaResponseDTO[].class));
    }

}
