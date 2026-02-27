package com.centroweg.SchoolManagementSystem.domain;

import java.time.LocalDateTime;

public class Classroom {
    private Long id;
    private Long classId;
    private LocalDateTime dateTime;
    private String subject;

    public Classroom(Long id, Long classId, LocalDateTime dateTime, String subject) {
        this.id = id;
        this.classId = classId;
        this.dateTime = dateTime;
        this.subject = subject;
    }

    public Classroom(Long classId, LocalDateTime dateTime, String subject) {
        this.classId = classId;
        this.dateTime = dateTime;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
