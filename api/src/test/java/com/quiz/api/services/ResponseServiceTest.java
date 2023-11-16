package com.quiz.api.services;

import com.quiz.api.dtos.responseDTO.ResponseDTO;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ResponseServiceTest {

    @Mock
    static ResponseService responseService;
    static ResponseDTO responseDTO;

    @BeforeAll
    public static void init() {

        responseDTO = new ResponseDTO();
        responseDTO.setId(1);
        responseDTO.setContent("Content test");

    }

    @Test
    public void createResponse() {

        when(responseService.save(responseDTO)).thenReturn(responseDTO);
        ResponseDTO returnedResponse = responseService.save(responseDTO);
        assertEquals(returnedResponse, responseDTO);
    }

    @Test
    public void updateResponse() {

        when(responseService.update(responseDTO)).thenReturn(responseDTO);
        ResponseDTO returnedResponse = responseService.update(responseDTO);
        assertEquals(returnedResponse, responseDTO);
    }

    @Test
    public void findResponseById() {

        when(responseService.findById(3)).thenReturn(responseDTO);
        ResponseDTO returnedResponse = responseService.findById(3);
        assertEquals(returnedResponse, responseDTO);
    }

    @Test
    public void findAllResponses() {

        List<ResponseDTO> responses = new ArrayList<>();

        responses.add(responseDTO);

        when(responseService.findAll()).thenReturn(responses);
        List<ResponseDTO> returnedResponses = responseService.findAll();
        assertEquals(returnedResponses, responses);
    }

    @Test
    public void deleteResponse() {

        // Todo delete a response test
    }

}

