package com.centroweg.SchoolManagementSystem.controller;

import com.centroweg.SchoolManagementSystem.dto.schoolclass.ClassResponseDto;
import com.centroweg.SchoolManagementSystem.dto.student.StudentResponseDto;
import com.centroweg.SchoolManagementSystem.dto.studentclass.StudentClassRequestDto;
import com.centroweg.SchoolManagementSystem.dto.studentclass.StudentClassResponseDto;
import com.centroweg.SchoolManagementSystem.dto.teacher.TeacherResponseDto;
import com.centroweg.SchoolManagementSystem.service.ClassStudentService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Queue;

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

        try {
            return classStudentService.registerStudentClass(studentClassRequestDto);
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
    }

    @GetMapping("/ClassStudent")
    public List<StudentClassResponseDto> listClassStudent() {
        try {
            return classStudentService.listClassStudent();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
    }

    @GetMapping("/class-student/{classId}/{studentId}")
    public StudentClassResponseDto searchById(@PathVariable Long classId, @PathVariable Long studentId) {
        try {
            return classStudentService.searchById(classId, studentId);
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
    }

    @PutMapping("/{classId}/{studentId}")
    public StudentClassResponseDto update(@PathVariable Long classId,
                                          @PathVariable Long studentId,
                                          @RequestBody StudentClassRequestDto dto) {

        try {
            return classStudentService.update(classId, studentId, dto);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @DeleteMapping("/ClassStudent/{classId}/{studentId}")
    public boolean delete(@PathVariable long classId,
                          @PathVariable long studentId) {

        try {
            return classStudentService.delete(classId, studentId);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
