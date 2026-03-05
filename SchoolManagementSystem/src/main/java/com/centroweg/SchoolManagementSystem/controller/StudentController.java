package com.centroweg.SchoolManagementSystem.controller;

import com.centroweg.SchoolManagementSystem.dto.student.StudentRequestDto;
import com.centroweg.SchoolManagementSystem.dto.student.StudentResponseDto;
import com.centroweg.SchoolManagementSystem.dto.teacher.TeacherRequestDto;
import com.centroweg.SchoolManagementSystem.dto.teacher.TeacherResponseDto;
import com.centroweg.SchoolManagementSystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

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

    @GetMapping("/Student")
    public List<StudentResponseDto> listStudents(){
        try{
            return studentService.listStudents();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
    }

    @GetMapping("/Student/{id}")
    public StudentResponseDto searchById(@PathVariable Long id){
        try{
            return studentService.searchById(id);
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
    }

    @PutMapping("/Student/{id}")
    public StudentResponseDto update(
            @PathVariable long id,
            @RequestBody StudentRequestDto studentRequestDto) {

        try {
            return studentService.update(studentRequestDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/Student/{id}")
    public boolean delete(@PathVariable long id) {

        try {
            return studentService.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
