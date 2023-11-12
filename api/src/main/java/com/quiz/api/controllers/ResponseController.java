package com.quiz.api.controllers;

import com.quiz.api.models.Question;
import com.quiz.api.models.Response;
import com.quiz.api.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/responses")
public class ResponseController {

    private final ResponseService responseService;

    @Autowired
    public ResponseController(ResponseService service) {
        responseService = service;
    }

    @PostMapping()
    public Response save(@RequestBody Response response) {
        return responseService.save(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        responseService.delete(id);
    }

}
