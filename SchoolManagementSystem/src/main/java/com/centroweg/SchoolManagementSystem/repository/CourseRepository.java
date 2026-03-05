package com.centroweg.SchoolManagementSystem.repository;

import com.centroweg.SchoolManagementSystem.domain.Course;
import com.centroweg.SchoolManagementSystem.domain.Student;
import com.centroweg.SchoolManagementSystem.util.ConnectionMySql;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {

    public Course registerCourse(Course course) throws SQLException{
        String query = """
                INSERT INTO Course
                (name, code)
                VALUES
                (?, ?)
                """;

        try(Connection conn = ConnectionMySql.connect();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, course.getName());
            stmt.setString(2, course.getCode());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                course.setId(rs.getLong(1));
                return course;
            }
        }
        return course;
    }

    public List<Course> listCourse() throws SQLException{
        List<Course> courses = new ArrayList<>();

        String query = """
                SELECT id, name, code
                FROM Course
                """;

        try(Connection conn = ConnectionMySql.connect();
        PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                courses.add(new Course(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("code")
                ));
            }
        }
        return courses;
    }

    public Course searchById(Long id) throws SQLException{
        String query = """
            SELECT id, name, code
            FROM Student
            WHERE id = ?
            """;

        try (Connection conn = ConnectionMySql.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Course(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("code")
                );
            }
        }
        return null;
    }
}
