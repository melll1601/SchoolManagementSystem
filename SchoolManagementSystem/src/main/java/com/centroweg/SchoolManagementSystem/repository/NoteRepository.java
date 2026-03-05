package com.centroweg.SchoolManagementSystem.repository;

import com.centroweg.SchoolManagementSystem.domain.Lesson;
import com.centroweg.SchoolManagementSystem.domain.Note;
import com.centroweg.SchoolManagementSystem.domain.Student;
import com.centroweg.SchoolManagementSystem.util.ConnectionMySql;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Repository
public class NoteRepository {

    public Note registerNote(Note note) throws SQLException{
        String query = """
                INSERT INTO Note
                (studentId, lessonId, value)
                VALUES
                (?, ?, ?)
                """;

        try(Connection conn = ConnectionMySql.connect();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, note.getStudentId());
            stmt.setLong(2, note.getLessonId());
            stmt.setDouble(3, note.getValue());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                note.setId(rs.getLong(1));
                return note;
            }
        }
        return note;
    }

    public List<Note> listNote() throws SQLException{
        List<Note> list = new ArrayList<>();

        String query = """
                SELECT id, studentId, lessonId, value
                FROM Note
                """;

        try(Connection conn = ConnectionMySql.connect();
        PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                list.add(new Note(
                        rs.getLong("id"),
                        rs.getLong("studentId"),
                        rs.getLong("lessonId"),
                        rs.getDouble("value")
                ));
            }
        }

        return list;
    }

    public Note searchById(Long id) throws SQLException{
        String query = """
            SELECT id, studentId, lessonId, value
            FROM Note
            WHERE id = ?
            """;

        try (Connection conn = ConnectionMySql.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Note(
                        rs.getLong("id"),
                        rs.getLong("studentId"),
                        rs.getLong("lessonId"),
                        rs.getDouble("value")
                );
            }
        }
        return null;
    }
}
