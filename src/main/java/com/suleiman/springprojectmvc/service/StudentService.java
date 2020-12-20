package com.suleiman.springprojectmvc.service;

import com.suleiman.springprojectmvc.dao.StudentDao;
import com.suleiman.springprojectmvc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("fake") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void insertStudent(Student student) {
        studentDao.insertStudent(student);
    }

    public Optional<Student> selectStudentById(Long id) {
        return studentDao.selectStudentById(id);
    }

    public List<Student> selectAllStudents() {
        return studentDao.selectAllStudents();
    }

    public void updateStudentById(Long id, Student updateStudent) {
        studentDao.updateStudentById(id, updateStudent);
    }

    public void deleteStudentById(Long id) {
        studentDao.deleteStudentById(id);
    }

}