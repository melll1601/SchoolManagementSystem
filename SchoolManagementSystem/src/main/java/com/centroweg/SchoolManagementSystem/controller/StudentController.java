package com.centroweg.SchoolManagementSystem.controller;

import com.centroweg.SchoolManagementSystem.dto.student.StudentRequestDto;
import com.centroweg.SchoolManagementSystem.dto.student.StudentResponseDto;
import com.centroweg.SchoolManagementSystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/School")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/Student")
    public StudentResponseDto registerStudent(
            @RequestBody StudentRequestDto studentRequestDto) {

        try {
            return studentService.registerStudent(studentRequestDto);

        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
    }
}
