package com.centroweg.SchoolManagementSystem.dto.note;

public record NoteResponseDto(
        Long id,
        Long studentId,
        Long lessonId,
        double value) {
}
