package com.centroweg.SchoolManagementSystem.repository;

import com.centroweg.SchoolManagementSystem.domain.Lesson;
import com.centroweg.SchoolManagementSystem.util.ConnectionMySql;
import org.springframework.stereotype.Repository;

import java.sql.*;

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

}
