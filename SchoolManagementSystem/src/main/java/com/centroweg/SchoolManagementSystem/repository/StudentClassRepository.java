package com.centroweg.SchoolManagementSystem.repository;

import com.centroweg.SchoolManagementSystem.domain.ClassStudent;
import com.centroweg.SchoolManagementSystem.util.ConnectionMySql;
import org.springframework.stereotype.Repository;

import java.sql.*;

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
}
