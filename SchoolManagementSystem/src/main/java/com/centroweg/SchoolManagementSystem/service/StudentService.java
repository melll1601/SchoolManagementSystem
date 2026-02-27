package com.centroweg.SchoolManagementSystem.service;

import com.centroweg.SchoolManagementSystem.domain.Student;
import com.centroweg.SchoolManagementSystem.dto.student.StudentRequestDto;
import com.centroweg.SchoolManagementSystem.dto.student.StudentResponseDto;
import com.centroweg.SchoolManagementSystem.mapper.StudentMapper;
import com.centroweg.SchoolManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class StudentService {

    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    public StudentService(StudentMapper studentMapper, StudentRepository studentRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
    }

    public StudentResponseDto registerStudent(StudentRequestDto studentRequestDto) throws SQLException {
        Student student = studentMapper.forEntity(studentRequestDto);
        return studentMapper.forResponseDto(studentRepository.registerStudent(student));
    }
}
