package com.centroweg.SchoolManagementSystem.service;

import com.centroweg.SchoolManagementSystem.domain.ClassSchool;
import com.centroweg.SchoolManagementSystem.domain.Student;
import com.centroweg.SchoolManagementSystem.dto.schoolclass.ClassRequestDto;
import com.centroweg.SchoolManagementSystem.dto.schoolclass.ClassResponseDto;
import com.centroweg.SchoolManagementSystem.dto.student.StudentResponseDto;
import com.centroweg.SchoolManagementSystem.mapper.ClassMapper;
import com.centroweg.SchoolManagementSystem.repository.ClassRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ClassService {

    private final ClassRepository classRepository;
    private final ClassMapper classMapper;
    public ClassService(ClassRepository classRepository, ClassMapper classMapper) {
        this.classRepository = classRepository;
        this.classMapper = classMapper;
    }

    public ClassResponseDto registerClass(ClassRequestDto classRequestDto) throws SQLException {
        ClassSchool classSchool = classMapper.forEntity(classRequestDto);
        return classMapper.forResponseDto(classRepository.registerClass(classSchool));
    }

    public List<ClassResponseDto> listClass() throws SQLException{
        List<ClassSchool> list = classRepository.listClass();
        return classMapper.forListResponse(list);
    }

    public ClassResponseDto searchById(Long id) throws SQLException{
        ClassSchool classSchool = classRepository.searchById(id);
        return classMapper.forResponseDto(classSchool);
    }
}
