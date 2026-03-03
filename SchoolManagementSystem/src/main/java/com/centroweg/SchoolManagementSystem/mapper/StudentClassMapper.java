package com.centroweg.SchoolManagementSystem.mapper;

import com.centroweg.SchoolManagementSystem.domain.ClassStudent;
import com.centroweg.SchoolManagementSystem.dto.studentclass.StudentClassRequestDto;
import com.centroweg.SchoolManagementSystem.dto.studentclass.StudentClassResponseDto;
import org.springframework.stereotype.Component;
@Component
public class StudentClassMapper {

    public ClassStudent forEntity(StudentClassRequestDto studentClassRequestDto) {
        return new ClassStudent(
                studentClassRequestDto.classId(),
                studentClassRequestDto.studentId()
        );
    }

    public StudentClassResponseDto forResponseDto(ClassStudent classStudent) {
        return new StudentClassResponseDto(
                classStudent.getClassId(),
                classStudent.getStudentId()
        );
    }
}