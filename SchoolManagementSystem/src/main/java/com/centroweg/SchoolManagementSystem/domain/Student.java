package com.centroweg.SchoolManagementSystem.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Student {

    private Long id;
    private String name;
    private String email;
    private String registration;
    private LocalDate birth_date;

    public Student(Long id, String name, String email, String registration, LocalDate birth_date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registration = registration;
        this.birth_date = birth_date;
    }

    public Student(String name, String email, String registration, LocalDate birth_date) {
        this.name = name;
        this.email = email;
        this.registration = registration;
        this.birth_date = birth_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }
}
