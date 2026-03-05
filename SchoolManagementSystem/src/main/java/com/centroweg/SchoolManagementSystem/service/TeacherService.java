package com.centroweg.SchoolManagementSystem.service;

import com.centroweg.SchoolManagementSystem.domain.Student;
import com.centroweg.SchoolManagementSystem.domain.Teacher;
import com.centroweg.SchoolManagementSystem.dto.student.StudentRequestDto;
import com.centroweg.SchoolManagementSystem.dto.student.StudentResponseDto;
import com.centroweg.SchoolManagementSystem.dto.teacher.TeacherRequestDto;
import com.centroweg.SchoolManagementSystem.dto.teacher.TeacherResponseDto;
import com.centroweg.SchoolManagementSystem.mapper.TeacherMapper;
import com.centroweg.SchoolManagementSystem.repository.TeacherRepository;
import com.centroweg.SchoolManagementSystem.util.ConnectionMySql;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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

    public List<TeacherResponseDto> listTeacher() throws SQLException{
        List<Teacher> listTeacher = teacherRepository.listTeacher();
        return teacherMapper.forListResponseDto(listTeacher);
    }

    public TeacherResponseDto searchById(Long id) throws SQLException{
        Teacher teacher = teacherRepository.searchById(id);
        return teacherMapper.forResponseDto(teacher);
    }

    public TeacherResponseDto update(TeacherRequestDto dto, long id) throws SQLException {

        Teacher teacher = teacherMapper.forEntity(dto);
        teacher.setId(id);
        teacherRepository.update(teacher);

        return teacherMapper.forResponseDto(teacher);
    }

    public boolean delete(long id) throws SQLException {
        return teacherRepository.delete(id);
    }
}
