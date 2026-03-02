package com.centroweg.SchoolManagementSystem.controller;

import com.centroweg.SchoolManagementSystem.dto.schoolclass.ClassRequestDto;
import com.centroweg.SchoolManagementSystem.dto.schoolclass.ClassResponseDto;
import com.centroweg.SchoolManagementSystem.service.ClassService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/School")
public class ClassController {
    private final ClassService classService;
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping("/Class")
    public ClassResponseDto registerClass(
            @RequestBody ClassRequestDto classRequestDto
            ) {

        try {
            return classService.registerClass(classRequestDto);
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
    }
}
