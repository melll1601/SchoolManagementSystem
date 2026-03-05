package com.centroweg.SchoolManagementSystem.controller;

import com.centroweg.SchoolManagementSystem.dto.student.StudentResponseDto;
import com.centroweg.SchoolManagementSystem.dto.teacher.TeacherRequestDto;
import com.centroweg.SchoolManagementSystem.dto.teacher.TeacherResponseDto;
import com.centroweg.SchoolManagementSystem.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/School")
public class TeacherController {
    private final TeacherService teacherService;
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/Teacher")
    public TeacherResponseDto registerTeacher(
            @RequestBody TeacherRequestDto teacherRequestDto
            ) {

        try {
            return teacherService.registerTeacher(teacherRequestDto);
        }catch (SQLException error){
            throw  new RuntimeException(error.getMessage());
        }

    }

    @GetMapping("/Teacher")
    public List<TeacherResponseDto> listTeacher(){
        try{
            return teacherService.listTeacher();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
    }

    @GetMapping("/Teacher/{id}")
    public TeacherResponseDto searchById(@PathVariable Long id) {
        try {
            return teacherService.searchById(id);
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
    }

    @PutMapping("/Teacher/{id}")
    public TeacherResponseDto update(
            @PathVariable long id,
            @RequestBody TeacherRequestDto teacherRequestDto) {

        try {
            return teacherService.update(teacherRequestDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/Teacher/{id}")
    public boolean delete(@PathVariable long id) {

        try {
            return teacherService.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
