package com.centroweg.SchoolManagementSystem.controller;

import com.centroweg.SchoolManagementSystem.dto.course.CourseRequestDto;
import com.centroweg.SchoolManagementSystem.dto.course.CourseResponseDto;
import com.centroweg.SchoolManagementSystem.service.CourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

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
}
