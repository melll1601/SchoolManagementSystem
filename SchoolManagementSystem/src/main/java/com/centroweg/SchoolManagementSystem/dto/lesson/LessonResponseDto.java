package com.centroweg.SchoolManagementSystem.dto.lesson;

import java.time.LocalDateTime;

public record LessonResponseDto(
        Long id,
        Long classId,
        LocalDateTime dateTime,
        String subject){
}
