package com.quiz.api.controllers;

import com.quiz.api.dtos.mediaDTO.MediaDTO;
import com.quiz.api.dtos.questionDTO.QuestionDTO;
import com.quiz.api.services.MediaService;
import com.quiz.api.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/medias")
public class MediaController {

    private final MediaService mediaService;

    @Autowired
    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> save(@RequestBody MediaDTO mediaDTO) throws Exception {

        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "media created");
            message.put("media", mediaService.save(mediaDTO));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch(Exception e){
            message.put("message", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping
    public  ResponseEntity<Map<String, Object>> update(@RequestBody MediaDTO mediaDTO) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("media", mediaService.update(mediaDTO));
            result.put("message", "Media updated with success!");
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            mediaService.delete(id);
            result.put("message", "Media deleted with success!");
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> media(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            if(mediaService.getMediaById(id) == null) {
                result.put("message", "Media with id "+id+" not found!");
                return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
            }
            result.put("media", mediaService.getMediaById(id));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> medias() throws Exception {
        Map<String, Object> message = new HashMap<>();
        try{
            if(mediaService.findAll().isEmpty()) {
                message.put("message", "No medias found!");
                return new ResponseEntity<>(message, HttpStatus.OK);
            }
            message.put("message", "medias found");
            message.put("medias", mediaService.findAll());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            throw new Exception("cannot find any media");
        }
    }
}

