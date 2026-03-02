package com.centroweg.SchoolManagementSystem.service;

import com.centroweg.SchoolManagementSystem.domain.Lesson;
import com.centroweg.SchoolManagementSystem.dto.lesson.LessonRequestDto;
import com.centroweg.SchoolManagementSystem.dto.lesson.LessonResponseDto;
import com.centroweg.SchoolManagementSystem.mapper.LessonMapper;
import com.centroweg.SchoolManagementSystem.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;

    public LessonService(LessonRepository lessonRepository, LessonMapper lessonMapper) {
        this.lessonRepository = lessonRepository;
        this.lessonMapper = lessonMapper;
    }

    public LessonResponseDto registerLesson(LessonRequestDto lessonRequestDto) throws SQLException {
        Lesson lesson = lessonMapper.forEntity(lessonRequestDto);
        return lessonMapper.forResponseDto(lessonRepository.registerLesson(lesson));
    }
}