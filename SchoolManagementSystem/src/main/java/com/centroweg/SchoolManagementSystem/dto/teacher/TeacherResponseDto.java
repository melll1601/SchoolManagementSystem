package com.centroweg.SchoolManagementSystem.dto.teacher;

public record TeacherResponseDto(
        Long id,
        String name,
        String email,
        String discipline) {
}
