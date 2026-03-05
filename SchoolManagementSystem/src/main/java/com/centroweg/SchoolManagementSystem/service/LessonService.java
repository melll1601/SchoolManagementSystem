package com.centroweg.SchoolManagementSystem.service;

import com.centroweg.SchoolManagementSystem.domain.Lesson;
import com.centroweg.SchoolManagementSystem.domain.Student;
import com.centroweg.SchoolManagementSystem.dto.lesson.LessonRequestDto;
import com.centroweg.SchoolManagementSystem.dto.lesson.LessonResponseDto;
import com.centroweg.SchoolManagementSystem.dto.student.StudentRequestDto;
import com.centroweg.SchoolManagementSystem.dto.student.StudentResponseDto;
import com.centroweg.SchoolManagementSystem.mapper.LessonMapper;
import com.centroweg.SchoolManagementSystem.repository.LessonRepository;
import com.centroweg.SchoolManagementSystem.util.ConnectionMySql;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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

    public List<LessonResponseDto> listLesson() throws SQLException {
        List<Lesson> list = lessonRepository.listLesson();
        return lessonMapper.forListResponseDto(list);
    }

    public LessonResponseDto searchById(Long id) throws SQLException{
        Lesson lesson = lessonRepository.searchById(id);
        return lessonMapper.forResponseDto(lesson);
    }

    public LessonResponseDto update(LessonRequestDto dto, long id) throws SQLException {

        Lesson lesson = lessonMapper.forEntity(dto);
        lesson.setId(id);
        lessonRepository.update(lesson);

        return lessonMapper.forResponseDto(lesson);
    }

    public boolean delete(long id) throws SQLException {
        return lessonRepository.delete(id);
    }
}