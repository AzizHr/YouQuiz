package com.quiz.api.services;

import com.quiz.api.dtos.levelDTO.LevelDTO;
import com.quiz.api.dtos.levelDTO.LevelResponseDTO;
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
public class LevelServiceTest {

    @Mock
    static LevelService levelService;
    static LevelDTO levelDTO;
    static LevelResponseDTO levelResponseDTO;

    @BeforeAll
    public static void init() {

        levelDTO = new LevelDTO();
        levelDTO.setId(3);
        levelDTO.setMaxPoints(10);
        levelDTO.setMinPoints(4);
        levelDTO.setDescription("Description");

        levelResponseDTO = new LevelResponseDTO();
        levelResponseDTO.setId(levelDTO.getId());
        levelResponseDTO.setMaxPoints(levelDTO.getMaxPoints());
        levelResponseDTO.setMinPoints(levelDTO.getMinPoints());
        levelResponseDTO.setDescription(levelDTO.getDescription());
        levelResponseDTO.setQuestions(new ArrayList<>());

    }

    @Test
    public void createLevel() {

        when(levelService.save(levelDTO)).thenReturn(levelResponseDTO);
        LevelResponseDTO returnedLevel = levelService.save(levelDTO);
        assertEquals(returnedLevel, levelResponseDTO);
    }

    @Test
    public void updateLevel() {

        when(levelService.update(levelDTO)).thenReturn(levelResponseDTO);
        LevelResponseDTO returnedLevel = levelService.update(levelDTO);
        assertEquals(returnedLevel, levelResponseDTO);
    }

    @Test
    public void findLevelById() {

        when(levelService.getLevelByID(3)).thenReturn(levelResponseDTO);
        LevelResponseDTO returnedLevel = levelService.getLevelByID(3);
        assertEquals(returnedLevel, levelResponseDTO);
    }

    @Test
    public void findAllLevels() {

        List<LevelResponseDTO> levels = new ArrayList<>();

        levels.add(levelResponseDTO);

        when(levelService.findAll()).thenReturn(levels);
        List<LevelResponseDTO> returnedLevels = levelService.findAll();
        assertEquals(returnedLevels, levels);
    }

    @Test
    public void deleteLevel() {

        // Todo delete a level test
    }

}
