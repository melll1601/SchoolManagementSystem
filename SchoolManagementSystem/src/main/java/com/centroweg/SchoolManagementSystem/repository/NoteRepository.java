package com.centroweg.SchoolManagementSystem.repository;

import com.centroweg.SchoolManagementSystem.domain.Note;
import com.centroweg.SchoolManagementSystem.util.ConnectionMySql;
import org.springframework.stereotype.Repository;

import java.sql.*;

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
}
