package com.centroweg.SchoolManagementSystem.domain;

public class ClassStudent {

    private Long studentId;
    private Long classId;

    public ClassStudent(Long studentId, Long classId) {
        this.studentId = studentId;
        this.classId = classId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }
}
