package com.centroweg.SchoolManagementSystem.controller;

import com.centroweg.SchoolManagementSystem.dto.course.CourseRequestDto;
import com.centroweg.SchoolManagementSystem.dto.course.CourseResponseDto;
import com.centroweg.SchoolManagementSystem.dto.teacher.TeacherRequestDto;
import com.centroweg.SchoolManagementSystem.dto.teacher.TeacherResponseDto;
import com.centroweg.SchoolManagementSystem.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/School")
public class CourseController {
    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/Course")
    public CourseResponseDto registerCourse(
            @RequestBody CourseRequestDto courseRequestDto
            ) {

        try {
            return courseService.registerCourse(courseRequestDto);
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
    }

    @GetMapping("/Course")
    public List<CourseResponseDto> listCourse(){
        try{
            return courseService.listCourses();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
    }

    @GetMapping("/Course/{id}")
    public CourseResponseDto searchById(@PathVariable Long id){
        try{
            return courseService.searchById(id);
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
    }

    @PutMapping("/Course/{id}")
    public CourseResponseDto update(
            @PathVariable long id,
            @RequestBody CourseRequestDto courseRequestDto) {

        try {
            return courseService.update(courseRequestDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/Course/{id}")
    public boolean delete(@PathVariable long id) {

        try {
            return courseService.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
