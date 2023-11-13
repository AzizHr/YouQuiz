package com.quiz.api.services;

import com.quiz.api.models.Response;
import com.quiz.api.repositories.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    private final ResponseRepository responseRepository;

    @Autowired
    public ResponseService(ResponseRepository repository) {
        responseRepository = repository;
    }

    public Response save(Response response) {
        return responseRepository.save(response);
    }

    public void delete(Integer id) {
        responseRepository.deleteById(id);
    }

    public Response findById(Integer id) {
        return responseRepository.findById(id).orElse(null);
    }
}
