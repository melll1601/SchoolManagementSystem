package com.centroweg.SchoolManagementSystem.repository;

import com.centroweg.SchoolManagementSystem.domain.ClassSchool;
import com.centroweg.SchoolManagementSystem.domain.Lesson;
import com.centroweg.SchoolManagementSystem.domain.Student;
import com.centroweg.SchoolManagementSystem.util.ConnectionMySql;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Repository
public class ClassRepository {

    public ClassSchool registerClass(ClassSchool classSchool) throws SQLException{
        String query = """
                INSERT INTO ClassSchool
                (name, courseId, teacherId)
                VALUES
                (?, ?, ?)
                """;

        try(Connection conn = ConnectionMySql.connect();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, classSchool.getName());
            stmt.setLong(2, classSchool.getCourseId());
            stmt.setLong(3, classSchool.getTeacherId());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                classSchool.setId(rs.getLong(1));
                return classSchool;
            }
        }

        return classSchool;
    }

    public List<ClassSchool> listClass() throws SQLException{
        List<ClassSchool> list = new ArrayList<>();

        String query = """
                SELECT id, name, courseId, teacherId
                FROM ClassSchool
                """;

        try(Connection conn = ConnectionMySql.connect();
        PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(new ClassSchool(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getLong("courseId"),
                        rs.getLong("teacherId")
                ));
            }
        }
        return list;
    }

    public ClassSchool searchById(Long id) throws SQLException{
        String query = """
            SELECT id, name, courseId, teacherId
            FROM ClassSchool
            WHERE id = ?
            """;

        try (Connection conn = ConnectionMySql.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new ClassSchool(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getLong("courseId"),
                        rs.getLong("teacherId")
                );
            }
        }
        return null;
    }

    public void update(ClassSchool classSchool) throws SQLException{
        String query = """
                UPDATE ClassSchool
                SET name = ?, courseId = ?, teacherId = ?
                WHERE id = ?
                """;

        try (Connection conn = ConnectionMySql.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, classSchool.getName());
            stmt.setLong(2, classSchool.getCourseId());
            stmt.setLong(3, classSchool.getTeacherId());
            stmt.setLong(4, classSchool.getId());
            stmt.executeUpdate();
        }
    }

    public boolean delete(long id) throws SQLException {

        String query = """
            DELETE FROM ClassSchool
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
