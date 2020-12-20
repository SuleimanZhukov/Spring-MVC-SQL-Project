package com.suleiman.springprojectmvc.model;

public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private String grades;
    private static Long unique;

    public Student(String firstName, String lastName, String grades) {
        this.id = (unique == 0) ? unique : unique + 1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGrades() {
        return grades;
    }
}