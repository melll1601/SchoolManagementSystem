package com.centroweg.SchoolManagementSystem.mapper;

import com.centroweg.SchoolManagementSystem.domain.ClassSchool;
import com.centroweg.SchoolManagementSystem.dto.schoolclass.ClassRequestDto;
import com.centroweg.SchoolManagementSystem.dto.schoolclass.ClassResponseDto;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<ClassResponseDto> forListResponse(List<ClassSchool> classSchools) throws SQLException{
        List<ClassResponseDto> list = new ArrayList<>();

        for (ClassSchool classSchool : classSchools){
            list.add(forResponseDto(classSchool));
        }
        return list;
    }
}
