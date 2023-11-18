package com.quiz.api.services;

import com.quiz.api.dtos.trainerDTO.TrainerDTO;
import com.quiz.api.dtos.trainerDTO.TrainerResponseDTO;
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
public class TrainerServiceTest {

    @Mock
    static TrainerService trainerService;
    static TrainerDTO trainerDTO;
    static TrainerResponseDTO trainerResponseDTO;

    @BeforeAll
    public static void init() {

        trainerDTO = new TrainerDTO();

        trainerResponseDTO = new TrainerResponseDTO();

    }

    @Test
    public void createTrainer() {

        when(trainerService.save(trainerDTO)).thenReturn(trainerResponseDTO);
        TrainerResponseDTO returnedTrainer = trainerService.save(trainerDTO);
        assertEquals(returnedTrainer, trainerResponseDTO);
    }

    @Test
    public void updateTrainer() {

        when(trainerService.update(trainerDTO)).thenReturn(trainerResponseDTO);
        TrainerResponseDTO returnedTrainer = trainerService.update(trainerDTO);
        assertEquals(returnedTrainer, trainerResponseDTO);
    }

    @Test
    public void findTrainerById() {

        when(trainerService.findById(3)).thenReturn(trainerResponseDTO);
        TrainerResponseDTO returnedTrainer = trainerService.findById(3);
        assertEquals(returnedTrainer, trainerResponseDTO);
    }

    @Test
    public void findAllTrainers() {

        List<TrainerResponseDTO> trainers = new ArrayList<>();

        trainers.add(trainerResponseDTO);

        when(trainerService.findAll()).thenReturn(trainers);
        List<TrainerResponseDTO> returnedTrainers = trainerService.findAll();
        assertEquals(returnedTrainers, trainers);
    }

    @Test
    public void deleteTrainer() {

        // Todo delete a trainer test
    }

}
