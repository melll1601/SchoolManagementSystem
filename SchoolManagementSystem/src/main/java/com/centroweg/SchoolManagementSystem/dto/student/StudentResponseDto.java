package com.centroweg.SchoolManagementSystem.dto.student;

import java.time.LocalDate;

public record StudentResponseDto(
        Long id,
        String name,
        String email,
        String registration,
        LocalDate birth_date) {
}
