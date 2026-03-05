package com.centroweg.SchoolManagementSystem.mapper;

import com.centroweg.SchoolManagementSystem.domain.Course;
import com.centroweg.SchoolManagementSystem.dto.course.CourseRequestDto;
import com.centroweg.SchoolManagementSystem.dto.course.CourseResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<CourseResponseDto> forListResponseDto(List<Course> courses){
        List <CourseResponseDto> list = new ArrayList<>();

        for (Course course : courses){
            list.add(forResponseDto(course));
        }
        return list;
    }
}
