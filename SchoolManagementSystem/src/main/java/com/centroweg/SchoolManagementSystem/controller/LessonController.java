package com.centroweg.SchoolManagementSystem.controller;

import com.centroweg.SchoolManagementSystem.dto.lesson.LessonRequestDto;
import com.centroweg.SchoolManagementSystem.dto.lesson.LessonResponseDto;
import com.centroweg.SchoolManagementSystem.dto.teacher.TeacherResponseDto;
import com.centroweg.SchoolManagementSystem.service.LessonService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

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

    @GetMapping("/Lesson")
    public List<LessonResponseDto> listLesson(){
        try {
            return classroomService.listLesson();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
    }

    @GetMapping("/Lesson/{id}")
    public LessonResponseDto searchById(@PathVariable Long id){
        try{
            return classroomService.searchById(id);
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
    }
}
