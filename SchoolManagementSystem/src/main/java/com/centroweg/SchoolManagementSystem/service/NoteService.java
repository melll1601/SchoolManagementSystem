package com.centroweg.SchoolManagementSystem.service;

import com.centroweg.SchoolManagementSystem.domain.Note;
import com.centroweg.SchoolManagementSystem.dto.note.NoteRequestDto;
import com.centroweg.SchoolManagementSystem.dto.note.NoteResponseDto;
import com.centroweg.SchoolManagementSystem.mapper.NoteMapper;
import com.centroweg.SchoolManagementSystem.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    public NoteService(NoteRepository noteRepository, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
    }

    public NoteResponseDto registerNote(NoteRequestDto noteRequestDto) throws SQLException {
        Note note = noteMapper.toEntity(noteRequestDto);
        return noteMapper.toResponseDto(noteRepository.registerNote(note));
    }
}
