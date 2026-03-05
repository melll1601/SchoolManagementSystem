package com.centroweg.SchoolManagementSystem.repository;

import com.centroweg.SchoolManagementSystem.domain.Lesson;
import com.centroweg.SchoolManagementSystem.domain.Note;
import com.centroweg.SchoolManagementSystem.domain.Student;
import com.centroweg.SchoolManagementSystem.util.ConnectionMySql;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LessonRepository {

    public Lesson registerLesson(Lesson lesson) throws SQLException{
        String query = """
                INSERT INTO Lesson
                (classId, dateTime, subject)
                VALUES
                (?, ?, ?)
                """;

        try(Connection conn = ConnectionMySql.connect();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setLong(1, lesson.getClassId());
            stmt.setTimestamp(2, Timestamp.valueOf(lesson.getDateTime()));
            stmt.setString(3, lesson.getSubject());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                lesson.setId(rs.getLong(1));
                return lesson;
            }
        }

        return lesson;
    }

    public List<Lesson> listLesson() throws SQLException{
        List<Lesson> list = new ArrayList<>();

        String query = """
                SELECT id, classId, dateTime, subject
                FROM Lesson
                """;

        try(Connection conn = ConnectionMySql.connect();
        PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                list.add(new Lesson(
                        rs.getLong("id"),
                        rs.getLong("classId"),
                        rs.getTimestamp("dateTime").toLocalDateTime(),
                        rs.getString("subject")
                ));
            }
        }

        return list;
    }

    public Lesson searchById(Long id) throws SQLException{
        String query = """
            SELECT id, classId, dateTime, subject
            FROM Lesson
            WHERE id = ?
            """;

        try (Connection conn = ConnectionMySql.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Lesson(
                        rs.getLong("id"),
                        rs.getLong("classId"),
                        rs.getTimestamp("dateTime").toLocalDateTime(),
                        rs.getString("subject")
                );
            }
        }
        return null;
    }

    public void update(Lesson lesson) throws SQLException{
        String query = """
                UPDATE Lesson
                SET classId = ?, dateTime = ?, subject = ?
                WHERE id = ?
                """;

        try (Connection conn = ConnectionMySql.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, lesson.getClassId());
            stmt.setTimestamp(2, Timestamp.valueOf(lesson.getDateTime()));
            stmt.setString(3, lesson.getSubject());
            stmt.setLong(4, lesson.getId());
            stmt.executeUpdate();
        }
    }

    public boolean delete(long id) throws SQLException {

        String query = """
            DELETE FROM Lesson
            WHERE id = ?
            """;

        try (Connection conn = ConnectionMySql.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;
        }
    }

}
