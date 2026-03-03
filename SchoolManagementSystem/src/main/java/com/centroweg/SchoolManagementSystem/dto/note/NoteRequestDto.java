package com.centroweg.SchoolManagementSystem.dto.note;

public record NoteRequestDto(
        Long studentId,
        Long lessonId,
        double value) {
}
