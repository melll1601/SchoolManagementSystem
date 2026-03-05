package com.centroweg.SchoolManagementSystem.service;

import com.centroweg.SchoolManagementSystem.domain.Student;
import com.centroweg.SchoolManagementSystem.dto.student.StudentRequestDto;
import com.centroweg.SchoolManagementSystem.dto.student.StudentResponseDto;
import com.centroweg.SchoolManagementSystem.mapper.StudentMapper;
import com.centroweg.SchoolManagementSystem.repository.StudentRepository;
import com.centroweg.SchoolManagementSystem.util.ConnectionMySql;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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

    public List<StudentResponseDto> listStudents()throws SQLException{
        List<Student> students = studentRepository.listStudent();
        return studentMapper.forListResponseDto(students);
    }

    public StudentResponseDto searchById(Long id) throws SQLException{
        Student student = studentRepository.searchById(id);
        return studentMapper.forResponseDto(student);
    }

    public StudentResponseDto update(StudentRequestDto dto, long id) throws SQLException {

        Student student = studentMapper.forEntity(dto);
        student.setId(id);
        studentRepository.update(student);

        return studentMapper.forResponseDto(student);
    }

    public boolean delete(long id) throws SQLException {
        return studentRepository.delete(id);
    }

}
