package com.centroweg.SchoolManagementSystem.domain;

public class Teacher {

    private Long id;
    private String name;
    private String email;
    private String discipline;

    public Teacher(Long id, String name, String email, String discipline) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.discipline = discipline;
    }

    public Teacher(String name, String email, String discipline) {
        this.name = name;
        this.email = email;
        this.discipline = discipline;
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

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
}
