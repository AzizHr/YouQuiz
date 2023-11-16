package com.quiz.api.services;

import com.quiz.api.dtos.levelDTO.LevelDTO;
import com.quiz.api.dtos.levelDTO.LevelResponseDTO;
import com.quiz.api.dtos.mediaDTO.MediaDTO;
import com.quiz.api.dtos.mediaDTO.MediaResponseDTO;
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
public class MediaServiceTest {

    @Mock
    static MediaService mediaService;
    static MediaDTO mediaDTO;
    static MediaResponseDTO mediaResponseDTO;

    @BeforeAll
    public static void init() {

        mediaDTO = new MediaDTO();

        mediaResponseDTO = new MediaResponseDTO();

    }

    @Test
    public void createMedia() {

        when(mediaService.save(mediaDTO)).thenReturn(mediaResponseDTO);
        MediaResponseDTO returnedMedia = mediaService.save(mediaDTO);
        assertEquals(returnedMedia, mediaResponseDTO);
    }

    @Test
    public void updateMedia() {

        when(mediaService.update(mediaDTO)).thenReturn(mediaResponseDTO);
        MediaResponseDTO returnedMedia = mediaService.update(mediaDTO);
        assertEquals(returnedMedia, mediaResponseDTO);
    }

    @Test
    public void findMediaById() {

        when(mediaService.getMediaById(3)).thenReturn(mediaResponseDTO);
        MediaResponseDTO returnedMedia = mediaService.getMediaById(3);
        assertEquals(returnedMedia, mediaResponseDTO);
    }

    @Test
    public void findAllMedias() {

        List<MediaResponseDTO> medias = new ArrayList<>();

        medias.add(mediaResponseDTO);

        when(mediaService.findAll()).thenReturn(medias);
        List<MediaResponseDTO> returnedLevels = mediaService.findAll();
        assertEquals(returnedLevels, medias);
    }

    @Test
    public void deleteMedia() {

        // Todo delete a media test
    }

}
