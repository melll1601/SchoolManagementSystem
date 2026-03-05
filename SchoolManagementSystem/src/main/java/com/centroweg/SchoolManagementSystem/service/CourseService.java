package com.centroweg.SchoolManagementSystem.service;

import com.centroweg.SchoolManagementSystem.domain.Course;
import com.centroweg.SchoolManagementSystem.domain.Student;
import com.centroweg.SchoolManagementSystem.dto.course.CourseRequestDto;
import com.centroweg.SchoolManagementSystem.dto.course.CourseResponseDto;
import com.centroweg.SchoolManagementSystem.dto.student.StudentResponseDto;
import com.centroweg.SchoolManagementSystem.mapper.CourseMapper;
import com.centroweg.SchoolManagementSystem.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CourseService {

    private final CourseMapper courseMapper;
    private final CourseRepository courseRepository;

    public CourseService(CourseMapper courseMapper, CourseRepository courseRepository) {
        this.courseMapper = courseMapper;
        this.courseRepository = courseRepository;
    }

    public CourseResponseDto registerCourse(CourseRequestDto courseRequestDto) throws SQLException{
        Course course = courseMapper.forEntity(courseRequestDto);
        return courseMapper.forResponseDto(courseRepository.registerCourse(course));
    }

    public List<CourseResponseDto> listCourses() throws SQLException{
        List<Course> courses = courseRepository.listCourse();
        return courseMapper.forListResponseDto(courses);
    }

    public CourseResponseDto searchById(Long id) throws SQLException{
        Course course = courseRepository.searchById(id);
        return courseMapper.forResponseDto(course);
    }
}
