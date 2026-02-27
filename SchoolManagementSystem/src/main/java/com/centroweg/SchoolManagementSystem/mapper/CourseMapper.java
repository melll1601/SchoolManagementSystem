package com.centroweg.SchoolManagementSystem.mapper;

import com.centroweg.SchoolManagementSystem.domain.Course;
import com.centroweg.SchoolManagementSystem.dto.course.CourseRequestDto;
import com.centroweg.SchoolManagementSystem.dto.course.CourseResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public Course forEntity(CourseRequestDto courseRequestDto){
        return new Course(
                courseRequestDto.name(),
                courseRequestDto.code()
        );
    }

    public CourseResponseDto forResponseDto(Course course){
        return new CourseResponseDto(
                course.getId(),
                course.getName(),
                course.getCode()
        );
    }
}
