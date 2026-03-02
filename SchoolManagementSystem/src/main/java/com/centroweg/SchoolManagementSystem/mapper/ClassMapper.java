package com.centroweg.SchoolManagementSystem.mapper;

import com.centroweg.SchoolManagementSystem.domain.ClassSchool;
import com.centroweg.SchoolManagementSystem.dto.schoolclass.ClassRequestDto;
import com.centroweg.SchoolManagementSystem.dto.schoolclass.ClassResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ClassMapper {

    public ClassSchool forEntity(ClassRequestDto classRequestDto){
        return new ClassSchool(
                classRequestDto.name(),
                classRequestDto.courseId(),
                classRequestDto.teacherId()
                );
    }

    public ClassResponseDto forResponseDto(ClassSchool classSchool){
        return new ClassResponseDto(
                classSchool.getId(),
                classSchool.getName(),
                classSchool.getCourseId(),
                classSchool.getTeacherId()
        );
    }
}
