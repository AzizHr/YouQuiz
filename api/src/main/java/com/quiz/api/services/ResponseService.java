package com.quiz.api.services;

import com.quiz.api.models.Level;
import com.quiz.api.models.Response;
import com.quiz.api.repositories.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Response update(Response response) {
        Response response1 = findById(response.getId());
        response1.setContent(response.getContent());

        return responseRepository.save(response1);
    }

    public List<Response> findAll() {
        return responseRepository.findAll();
    }
}
