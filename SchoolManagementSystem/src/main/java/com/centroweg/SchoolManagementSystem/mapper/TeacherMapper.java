package com.centroweg.SchoolManagementSystem.mapper;

import com.centroweg.SchoolManagementSystem.domain.Teacher;
import com.centroweg.SchoolManagementSystem.dto.teacher.TeacherRequestDto;
import com.centroweg.SchoolManagementSystem.dto.teacher.TeacherResponseDto;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {

    public Teacher forEntity(TeacherRequestDto teacherRequestDto){
        return new Teacher(
                teacherRequestDto.name(),
                teacherRequestDto.email(),
                teacherRequestDto.discipline()
        );
    }
    public TeacherResponseDto forResponseDto(Teacher teacher){
        return new TeacherResponseDto(
                teacher.getId(),
                teacher.getName(),
                teacher.getEmail(),
                teacher.getDiscipline()
        );
    }
}
