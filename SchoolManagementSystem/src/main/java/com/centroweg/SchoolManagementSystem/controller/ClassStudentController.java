package com.centroweg.SchoolManagementSystem.controller;

import com.centroweg.SchoolManagementSystem.dto.schoolclass.ClassResponseDto;
import com.centroweg.SchoolManagementSystem.dto.studentclass.StudentClassRequestDto;
import com.centroweg.SchoolManagementSystem.dto.studentclass.StudentClassResponseDto;
import com.centroweg.SchoolManagementSystem.service.ClassStudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController()
@RequestMapping("/School")
public class ClassStudentController {
    private final ClassStudentService classStudentService;
    public ClassStudentController(ClassStudentService classStudentService) {
        this.classStudentService = classStudentService;
    }

    @PostMapping("/ClassStudent")
    public StudentClassResponseDto registerClassStudent(
            @RequestBody StudentClassRequestDto studentClassRequestDto
            ) {

        try{
            return classStudentService.registerStudentClass(studentClassRequestDto);
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
    }
}
