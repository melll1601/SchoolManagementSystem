package com.centroweg.SchoolManagementSystem.controller;

import com.centroweg.SchoolManagementSystem.dto.note.NoteRequestDto;
import com.centroweg.SchoolManagementSystem.dto.note.NoteResponseDto;
import com.centroweg.SchoolManagementSystem.dto.teacher.TeacherResponseDto;
import com.centroweg.SchoolManagementSystem.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/School")
public class NoteController {


    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }


    @PostMapping("/Note")
    public NoteResponseDto registerNote(
            @RequestBody NoteRequestDto noteRequestDto
            ) {

        try {
            return noteService.registerNote(noteRequestDto);
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
    }

    @GetMapping("/Note")
    public List<NoteResponseDto> listNote(){
        try{
            return noteService.listNote();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
    }

    @GetMapping("/Note/{id}")
    public NoteResponseDto searchById(@PathVariable Long id){
        try{
            return noteService.searchById(id);
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
    }
}
