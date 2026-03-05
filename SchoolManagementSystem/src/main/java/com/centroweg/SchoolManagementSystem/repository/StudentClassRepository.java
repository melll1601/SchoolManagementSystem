package com.centroweg.SchoolManagementSystem.repository;

import com.centroweg.SchoolManagementSystem.domain.ClassStudent;
import com.centroweg.SchoolManagementSystem.domain.Note;
import com.centroweg.SchoolManagementSystem.domain.Student;
import com.centroweg.SchoolManagementSystem.util.ConnectionMySql;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentClassRepository {

    public ClassStudent registerClassStudent(ClassStudent classStudent) throws SQLException{
        String query = """
                INSERT INTO ClassStudent
                (classId, studentId)
                VALUES
                (?, ?)
                """;

        try(Connection conn = ConnectionMySql.connect();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setLong(1, classStudent.getClassId());
            stmt.setLong(2, classStudent.getStudentId());
            stmt.executeUpdate();

            return classStudent;
        }
    }

    public List<ClassStudent> listClassStudent() throws SQLException{
        List<ClassStudent> list = new ArrayList<>();

        String query = """
                SELECT classId, studentId
                FROM ClassStudent
                """;

        try(Connection conn = ConnectionMySql.connect();
        PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                list.add(new ClassStudent(
                        rs.getLong("classId"),
                        rs.getLong("studentId")
                ));
            }
        }

        return list;
    }

    public ClassStudent searchById(Long classId, Long studentId) throws SQLException {

        String query = """
        SELECT classId, studentId
        FROM ClassStudent
        WHERE classId = ? AND studentId = ?
        """;

        try (Connection conn = ConnectionMySql.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, classId);
            stmt.setLong(2, studentId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new ClassStudent(
                        rs.getLong("studentId"),
                        rs.getLong("classId")
                );
            }
        }

        return null;
    }

    public void update(Long oldClassId,
                       Long oldStudentId,
                       ClassStudent classStudent) throws SQLException {

        String query = """
        UPDATE ClassStudent
        SET classId = ?, studentId = ?
        WHERE classId = ? AND studentId = ?
        """;

        try (Connection conn = ConnectionMySql.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, classStudent.getClassId());
            stmt.setLong(2, classStudent.getStudentId());
            stmt.setLong(3, oldClassId);
            stmt.setLong(4, oldStudentId);

            stmt.executeUpdate();
        }
    }
    public void delete(ClassStudent classStudent) throws SQLException {

        String query = """
            DELETE FROM ClassStudent
            WHERE classId = ? AND studentId = ?
            """;

        try (Connection conn = ConnectionMySql.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, classStudent.getClassId());
            stmt.setLong(2, classStudent.getStudentId());

            stmt.executeUpdate();
        }
    }
}
