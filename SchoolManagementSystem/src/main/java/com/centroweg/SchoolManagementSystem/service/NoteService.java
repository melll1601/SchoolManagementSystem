package com.centroweg.SchoolManagementSystem.service;

import com.centroweg.SchoolManagementSystem.domain.Note;
import com.centroweg.SchoolManagementSystem.domain.Student;
import com.centroweg.SchoolManagementSystem.dto.note.NoteRequestDto;
import com.centroweg.SchoolManagementSystem.dto.note.NoteResponseDto;
import com.centroweg.SchoolManagementSystem.dto.student.StudentRequestDto;
import com.centroweg.SchoolManagementSystem.dto.student.StudentResponseDto;
import com.centroweg.SchoolManagementSystem.mapper.NoteMapper;
import com.centroweg.SchoolManagementSystem.repository.NoteRepository;
import com.centroweg.SchoolManagementSystem.util.ConnectionMySql;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    public NoteService(NoteRepository noteRepository, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
    }

    public NoteResponseDto registerNote(NoteRequestDto noteRequestDto) throws SQLException {
        Note note = noteMapper.forEntity(noteRequestDto);
        return noteMapper.forResponseDto(noteRepository.registerNote(note));
    }

    public List<NoteResponseDto> listNote() throws SQLException{
        List<Note> list = noteRepository.listNote();
        return noteMapper.forListResponse(list);
    }

    public NoteResponseDto searchById(Long id) throws SQLException{
        Note note = noteRepository.searchById(id);
        return noteMapper.forResponseDto(note);
    }

    public NoteResponseDto update(NoteRequestDto dto, long id) throws SQLException {

        Note note = noteMapper.forEntity(dto);
        note.setId(id);
        noteRepository.update(note);

        return noteMapper.forResponseDto(note);
    }

    public boolean delete(long id) throws SQLException {
        return noteRepository.delete(id);
    }
}
