package com.centroweg.SchoolManagementSystem.mapper;

import com.centroweg.SchoolManagementSystem.domain.Lesson;
import com.centroweg.SchoolManagementSystem.dto.lesson.LessonRequestDto;
import com.centroweg.SchoolManagementSystem.dto.lesson.LessonResponseDto;
import org.springframework.stereotype.Component;

@Component
public class LessonMapper {

    public Lesson forEntity(LessonRequestDto lessonRequestDto){
        return new Lesson(
                lessonRequestDto.classId(),
                lessonRequestDto.dateTime(),
                lessonRequestDto.subject()
        );
    }

    public LessonResponseDto forResponseDto(Lesson lesson){
        return new LessonResponseDto(
                lesson.getId(),
                lesson.getClassId(),
                lesson.getDateTime(),
                lesson.getSubject()
        );
    }
}
