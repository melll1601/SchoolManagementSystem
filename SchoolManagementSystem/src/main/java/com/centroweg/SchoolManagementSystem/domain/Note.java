package com.centroweg.SchoolManagementSystem.domain;

public class Note {
    private Long id;
    private Long studentId;
    private Long lessonId;
    private double value;

    public Note(Long id, Long studentId, Long lessonId, double value) {
        this.id = id;
        this.studentId = studentId;
        this.lessonId = lessonId;
        this.value = value;
    }

    public Note(Long studentId, Long lessonId, double value) {
        this.studentId = studentId;
        this.lessonId = lessonId;
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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }
}
