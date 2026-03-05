package com.centroweg.SchoolManagementSystem.service;

import com.centroweg.SchoolManagementSystem.domain.ClassStudent;
import com.centroweg.SchoolManagementSystem.domain.Student;
import com.centroweg.SchoolManagementSystem.dto.student.StudentResponseDto;
import com.centroweg.SchoolManagementSystem.dto.studentclass.StudentClassRequestDto;
import com.centroweg.SchoolManagementSystem.dto.studentclass.StudentClassResponseDto;
import com.centroweg.SchoolManagementSystem.mapper.StudentClassMapper;
import com.centroweg.SchoolManagementSystem.repository.StudentClassRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ClassStudentService {

    private final StudentClassMapper studentClassMapper;
    private final StudentClassRepository studentClassRepository;
    public ClassStudentService(StudentClassMapper studentClassMapper, StudentClassRepository studentClassRepository) {
        this.studentClassMapper = studentClassMapper;
        this.studentClassRepository = studentClassRepository;
    }

    public StudentClassResponseDto registerStudentClass(StudentClassRequestDto studentClassRequestDto) throws SQLException {
        ClassStudent classStudent = studentClassMapper.forEntity(studentClassRequestDto);
        return studentClassMapper.forResponseDto(studentClassRepository.registerClassStudent(classStudent));
    }

    public List<StudentClassResponseDto> listClassStudent() throws SQLException{
        List<ClassStudent> list = studentClassRepository.listClassStudent();
        return studentClassMapper.forListResponseDto(list);
    }

    public StudentClassResponseDto searchById(Long id) throws SQLException{
        ClassStudent classStudent = studentClassRepository.searchById(id);
        return studentClassMapper.forResponseDto(classStudent);
    }
}
