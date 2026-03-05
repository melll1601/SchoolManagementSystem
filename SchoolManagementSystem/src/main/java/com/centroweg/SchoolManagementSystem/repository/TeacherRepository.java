package com.centroweg.SchoolManagementSystem.repository;

import com.centroweg.SchoolManagementSystem.domain.Student;
import com.centroweg.SchoolManagementSystem.domain.Teacher;
import com.centroweg.SchoolManagementSystem.util.ConnectionMySql;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TeacherRepository {

    public Teacher registerTeacher(Teacher teacher) throws SQLException{
        String query = """
                INSERT INTO Teacher
                (name, email, discipline)
                VALUES
                (?, ?, ?)
                """;

        try(Connection conn = ConnectionMySql.connect();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, teacher.getName());
            stmt.setString(2, teacher.getEmail());
            stmt.setString(3, teacher.getDiscipline());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                teacher.setId(rs.getLong(1));
                return teacher;
            }
        }

        return teacher;
    }

    public List<Teacher> listTeacher() throws SQLException{
        List<Teacher> teachers = new ArrayList<>();

        String query = """
                SELECT id, name, email, discipline
                FROM Teacher
                """;

        try(Connection conn = ConnectionMySql.connect();
        PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                teachers.add(new Teacher(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("discipline")
                ));
            }
        }

        return teachers;
    }

    public Teacher searchById(Long id) throws SQLException{
        String query = """
            SELECT id, name, email, discipline
            FROM Teacher
            WHERE id = ?
            """;

        try (Connection conn = ConnectionMySql.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Teacher(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("discipline")
                );
            }
        }
        return null;
    }

    public void update(Teacher teacher) throws SQLException{
        String query = """
                UPDATE Teacher
                SET name = ?, email = ?, discipline = ?
                WHERE id = ?
                """;

        try (Connection conn = ConnectionMySql.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, teacher.getName());
            stmt.setString(2, teacher.getEmail());
            stmt.setString(3, teacher.getDiscipline());
            stmt.setLong(4, teacher.getId());
            stmt.executeUpdate();
        }
    }
    public boolean delete(long id) throws SQLException {

        String query = """
            DELETE FROM Teacher
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
