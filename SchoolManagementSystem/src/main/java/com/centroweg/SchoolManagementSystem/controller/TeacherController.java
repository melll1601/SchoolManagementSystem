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
    public TeacherResponseDto searchById(@PathVariable Long id){
        try{
            return teacherService.searchById(id);
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
    }
}
