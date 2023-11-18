package com.quiz.api.services;

import com.quiz.api.dtos.studentDTO.StudentDTO;
import com.quiz.api.dtos.studentDTO.StudentResponseDTO;
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
public class StudentServiceTest {

    @Mock
    static StudentService studentService;
    static StudentDTO studentDTO;
    static StudentResponseDTO studentResponseDTO;

    @BeforeAll
    public static void init() {

        studentDTO = new StudentDTO();

        studentResponseDTO = new StudentResponseDTO();

    }

    @Test
    public void createStudent() {

        when(studentService.save(studentDTO)).thenReturn(studentResponseDTO);
        StudentResponseDTO returnedStudent = studentService.save(studentDTO);
        assertEquals(returnedStudent, studentResponseDTO);
    }

    @Test
    public void updateStudent() {

        when(studentService.update(studentDTO)).thenReturn(studentResponseDTO);
        StudentResponseDTO returnedStudent = studentService.update(studentDTO);
        assertEquals(returnedStudent, studentResponseDTO);
    }

    @Test
    public void findStudentById() {

        when(studentService.findById(3)).thenReturn(studentResponseDTO);
        StudentResponseDTO returnedStudent = studentService.findById(3);
        assertEquals(returnedStudent, studentResponseDTO);
    }

    @Test
    public void findAllStudents() {

        List<StudentResponseDTO> students = new ArrayList<>();

        students.add(studentResponseDTO);

        when(studentService.findAll()).thenReturn(students);
        List<StudentResponseDTO> returnedStudents = studentService.findAll();
        assertEquals(returnedStudents, students);
    }

    @Test
    public void deleteStudent() {

        // Todo delete a student test
    }

}
