package com.centroweg.SchoolManagementSystem.dto.lesson;

import java.time.LocalDateTime;

public record LessonRequestDto(
       Long classId,
       LocalDateTime dateTime,
       String subject) {
}
