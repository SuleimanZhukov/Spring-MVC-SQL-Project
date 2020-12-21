package com.suleiman.springprojectmvc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

public class Student {

    private Long id = 0L;
    private String firstName;
    private String lastName;
    private String grades;
    private static Long unique = 0L;

    public Student(@JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("grades") String grades) {
        this.id = unique++;
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