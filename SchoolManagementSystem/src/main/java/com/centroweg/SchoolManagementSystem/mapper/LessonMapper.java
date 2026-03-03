package com.centroweg.SchoolManagementSystem.mapper;

import com.centroweg.SchoolManagementSystem.domain.Lesson;
import com.centroweg.SchoolManagementSystem.dto.lesson.LessonRequestDto;
import com.centroweg.SchoolManagementSystem.dto.lesson.LessonResponseDto;
import org.springframework.stereotype.Component;

@Component
public class LessonMapper {

    public Lesson forEntity(LessonRequestDto classroomRequestDto){
        return new Lesson(
                classroomRequestDto.classId(),
                classroomRequestDto.dateTime(),
                classroomRequestDto.subject()
        );
    }

    public LessonResponseDto forResponseDto(Lesson classroom){
        return new LessonResponseDto(
                classroom.getId(),
                classroom.getClassId(),
                classroom.getDateTime(),
                classroom.getSubject()
        );
    }
}
