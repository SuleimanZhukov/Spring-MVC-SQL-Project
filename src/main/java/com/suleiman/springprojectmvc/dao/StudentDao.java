package com.suleiman.springprojectmvc.dao;

import com.suleiman.springprojectmvc.model.Student;

import java.util.List;

public interface StudentDao {

    int insertStudent(Student student);

    Student selectStudentById(Long id);

    List<Student> selectAllStudents();

    int updateStudentById(Long id, Student updateStudent);

    int deleteStudentById(Long id);

}