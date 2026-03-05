package com.centroweg.SchoolManagementSystem.mapper;

import com.centroweg.SchoolManagementSystem.domain.Student;
import com.centroweg.SchoolManagementSystem.dto.student.StudentRequestDto;
import com.centroweg.SchoolManagementSystem.dto.student.StudentResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {

    public Student forEntity(StudentRequestDto studentRequestDto){
        return new Student(
                studentRequestDto.name(),
                studentRequestDto.email(),
                studentRequestDto.registration(),
                studentRequestDto.birth_date()
        );
    }

    public StudentResponseDto forResponseDto(Student student){
        return new StudentResponseDto(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getRegistration(),
                student.getBirth_date()
        );
    }

    public List<StudentResponseDto> forListResponseDto(List<Student> students) {
        List<StudentResponseDto> list = new ArrayList<>();

        for (Student student : students){
            list.add(forResponseDto(student));
        }
        return list;
    }
}
