package com.centroweg.SchoolManagementSystem.repository;

import com.centroweg.SchoolManagementSystem.domain.ClassSchool;
import com.centroweg.SchoolManagementSystem.util.ConnectionMySql;
import org.springframework.stereotype.Repository;

import java.sql.*;

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
}
