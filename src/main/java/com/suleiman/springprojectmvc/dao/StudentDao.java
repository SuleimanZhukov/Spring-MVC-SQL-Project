package com.suleiman.springprojectmvc.dao;

import com.suleiman.springprojectmvc.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {

    int insertStudent(Student student);

    Optional<Student> selectStudentById(Long id);

    List<Student> selectAllStudents();

    int updateStudentById(Long id, Student updateStudent);

    int deleteStudentById(Long id);

}