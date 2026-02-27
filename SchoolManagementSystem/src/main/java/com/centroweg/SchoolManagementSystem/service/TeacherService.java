package com.centroweg.SchoolManagementSystem.service;

import com.centroweg.SchoolManagementSystem.domain.Teacher;
import com.centroweg.SchoolManagementSystem.dto.teacher.TeacherRequestDto;
import com.centroweg.SchoolManagementSystem.dto.teacher.TeacherResponseDto;
import com.centroweg.SchoolManagementSystem.mapper.TeacherMapper;
import com.centroweg.SchoolManagementSystem.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    public TeacherService(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    public TeacherResponseDto registerTeacher(TeacherRequestDto teacherRequestDto) throws SQLException {
        Teacher teacher = teacherMapper.forEntity(teacherRequestDto);
        return teacherMapper.forResponseDto(teacherRepository.registerTeacher(teacher));
    }

}
