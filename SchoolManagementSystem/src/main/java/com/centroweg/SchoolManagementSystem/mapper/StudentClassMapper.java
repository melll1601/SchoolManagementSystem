package com.centroweg.SchoolManagementSystem.mapper;

import com.centroweg.SchoolManagementSystem.domain.ClassStudent;
import com.centroweg.SchoolManagementSystem.domain.Student;
import com.centroweg.SchoolManagementSystem.dto.student.StudentResponseDto;
import com.centroweg.SchoolManagementSystem.dto.studentclass.StudentClassRequestDto;
import com.centroweg.SchoolManagementSystem.dto.studentclass.StudentClassResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<StudentClassResponseDto> forListResponseDto(List<ClassStudent> classStudents){
        List<StudentClassResponseDto> list = new ArrayList<>();

        for (ClassStudent classStudent : classStudents){
            list.add(forResponseDto(classStudent));
        }
        return list;
    }


}