package com.centroweg.SchoolManagementSystem.repository;

import com.centroweg.SchoolManagementSystem.domain.Student;
import com.centroweg.SchoolManagementSystem.util.ConnectionMySql;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    public Student registerStudent(Student student) throws SQLException {

        String query = """
                INSERT INTO Student
                (name, email, registration, birth_date)
                VALUES
                (?, ?, ?, ?)
                """;

        try(Connection conn = ConnectionMySql.connect();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getRegistration());
            stmt.setDate(4, Date.valueOf(student.getBirth_date()));
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()){
                student.setId(rs.getLong(1));
                return student;
            }

        }catch (SQLException error){
            error.printStackTrace();
        }

        return student;
    }

    public List<Student> listStudent() throws SQLException{
        List<Student> students = new ArrayList<>();

        String query = """
                SELECT id, name, email, registration, birth_date
                FROM Student
                """;

        try(Connection conn = ConnectionMySql.connect();
        PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                students.add(new Student(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("registration"),
                        rs.getDate("birth_date").toLocalDate()
                ));
            }
        }
        return students;
    }

    public Student searchById(Long id) throws SQLException{
        String query = """
            SELECT id, name, email, registration, birth_date
            FROM Student
            WHERE id = ?
            """;

        try (Connection conn = ConnectionMySql.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("registration"),
                        rs.getDate("birth_date").toLocalDate()
                );
            }
        }
        return null;
    }

}
