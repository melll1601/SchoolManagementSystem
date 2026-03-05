package com.centroweg.SchoolManagementSystem.controller;

import com.centroweg.SchoolManagementSystem.domain.ClassSchool;
import com.centroweg.SchoolManagementSystem.dto.schoolclass.ClassRequestDto;
import com.centroweg.SchoolManagementSystem.dto.schoolclass.ClassResponseDto;
import com.centroweg.SchoolManagementSystem.dto.teacher.TeacherRequestDto;
import com.centroweg.SchoolManagementSystem.dto.teacher.TeacherResponseDto;
import com.centroweg.SchoolManagementSystem.service.ClassService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

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

    @GetMapping("/Class")
    public List<ClassResponseDto> listClass(){
        try{
            return classService.listClass();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
    }

    @GetMapping("/Class/{id}")
    public ClassResponseDto searchById(@PathVariable Long id){
        try{
            return classService.searchById(id);
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
    }

    @PutMapping("/Class/{id}")
    public ClassResponseDto update(
            @PathVariable long id,
            @RequestBody ClassRequestDto classRequestDto) {

        try {
            return classService.update(classRequestDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/Class/{id}")
    public boolean delete(@PathVariable long id) {

        try {
            return classService.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
