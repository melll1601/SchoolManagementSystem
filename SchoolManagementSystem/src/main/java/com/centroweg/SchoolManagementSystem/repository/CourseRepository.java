package com.centroweg.SchoolManagementSystem.repository;

import com.centroweg.SchoolManagementSystem.domain.Course;
import com.centroweg.SchoolManagementSystem.util.ConnectionMySql;
import org.springframework.stereotype.Repository;

import java.sql.*;

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
}
