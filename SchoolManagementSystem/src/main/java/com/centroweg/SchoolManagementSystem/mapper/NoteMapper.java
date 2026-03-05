package com.centroweg.SchoolManagementSystem.mapper;

import com.centroweg.SchoolManagementSystem.domain.Note;
import com.centroweg.SchoolManagementSystem.dto.note.NoteRequestDto;
import com.centroweg.SchoolManagementSystem.dto.note.NoteResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoteMapper {

    public Note forEntity(NoteRequestDto noteRequestDto){
        return new Note(
                noteRequestDto.studentId(),
                noteRequestDto.lessonId(),
                noteRequestDto.value()
        );
    }

    public NoteResponseDto forResponseDto(Note note){
        return new NoteResponseDto(
                note.getId(),
                note.getStudentId(),
                note.getLessonId(),
                note.getValue()
        );
    }

    public List<NoteResponseDto> forListResponse(List<Note> notes){
        List<NoteResponseDto> list = new ArrayList<>();

        for (Note note : notes){
            list.add(forResponseDto(note));
        }

        return list;
    }
}
