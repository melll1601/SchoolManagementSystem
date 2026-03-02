package com.centroweg.SchoolManagementSystem.controller;

import com.centroweg.SchoolManagementSystem.dto.lesson.LessonRequestDto;
import com.centroweg.SchoolManagementSystem.dto.lesson.LessonResponseDto;
import com.centroweg.SchoolManagementSystem.service.LessonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/School")
public class LessonController {

    private final LessonService classroomService;

    public LessonController(LessonService classroomService) {
        this.classroomService = classroomService;
    }

    @PostMapping("/Lesson")
    public LessonResponseDto registerClassroom(
            @RequestBody LessonRequestDto lessonRequestDto
            ) {

        try {
            return classroomService.registerLesson(lessonRequestDto);
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
    }
}
