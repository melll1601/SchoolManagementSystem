package com.centroweg.SchoolManagementSystem.dto.schoolclass;

public record ClassRequestDto(
        String name,
        Long courseId,
        Long teacherId ){
}
