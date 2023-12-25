package com.quiz.api.services;

import com.quiz.api.dtos.subjectDTO.SubjectDTO;
import com.quiz.api.dtos.subjectDTO.SubjectResponseDTO;
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
public class SubjectServiceTest {

    @Mock
    static SubjectService subjectService;
    static SubjectDTO subjectDTO;
    static SubjectResponseDTO subjectResponseDTO;

    @BeforeAll
    public static void init() {

        subjectDTO = new SubjectDTO();
        subjectDTO.setId(3);
        subjectDTO.setTitle("Subject Test 1");

        subjectResponseDTO = new SubjectResponseDTO();
        subjectResponseDTO.setId(subjectDTO.getId());
        subjectResponseDTO.setTitle(subjectDTO.getTitle());
        subjectResponseDTO.setChildren(new ArrayList<>());

    }

    @Test
    public void createSubject() {

        when(subjectService.save(subjectDTO)).thenReturn(subjectResponseDTO);
        SubjectResponseDTO returnedSubject = subjectService.save(subjectDTO);
        assertEquals(returnedSubject, subjectResponseDTO);
    }

    @Test
    public void updateSubject() {

        when(subjectService.update(subjectDTO)).thenReturn(subjectResponseDTO);
        SubjectResponseDTO returnedSubject = subjectService.update(subjectDTO);
        assertEquals(returnedSubject, subjectResponseDTO);
    }

    @Test
    public void findSubjectById() {

        when(subjectService.getSubjectByID(3)).thenReturn(subjectResponseDTO);
        SubjectResponseDTO returnedSubject = subjectService.getSubjectByID(3);
        assertEquals(returnedSubject, subjectResponseDTO);
    }

    @Test
    public void findAllSubjects() {

        List<SubjectResponseDTO> subjects = new ArrayList<>();

        subjects.add(subjectResponseDTO);

        when(subjectService.findAll(0, 4)).thenReturn(subjects);
        List<SubjectResponseDTO> returnedSubjects = subjectService.findAll(0, 4);
        assertEquals(returnedSubjects, subjects);
    }

    @Test
    public void deleteSubject() {

        // Todo delete a subject test
    }

}
