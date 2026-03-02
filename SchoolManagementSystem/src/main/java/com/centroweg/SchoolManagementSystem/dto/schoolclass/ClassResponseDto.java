package com.centroweg.SchoolManagementSystem.dto.schoolclass;

public record ClassResponseDto(
        Long id,
        String name,
        Long courseId,
        Long teacherId) {
}
