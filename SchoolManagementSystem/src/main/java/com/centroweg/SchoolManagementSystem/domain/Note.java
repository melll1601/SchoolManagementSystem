package com.centroweg.SchoolManagementSystem.domain;

public class Note {
    private Long id;
    private Long studentId;
    private Long classroomId;
    private double value;

    public Note(Long id, Long studentId, Long classroomId, double value) {
        this.id = id;
        this.studentId = studentId;
        this.classroomId = classroomId;
        this.value = value;
    }

    public Note(Long studentId, Long classroomId, double value) {
        this.studentId = studentId;
        this.classroomId = classroomId;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
