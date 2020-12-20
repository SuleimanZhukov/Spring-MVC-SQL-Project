package com.suleiman.springprojectmvc.api;

import com.suleiman.springprojectmvc.model.Student;
import com.suleiman.springprojectmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/student")
@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public void addStudent(Student student) {
        studentService.insertStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentService.selectAllStudents();
    }

    public Optional<Student> selectStudentById(Long id) {
        return studentService.selectStudentById(id);
    }

    public int updateStudentById(Long id, Student updateStudent) {
        studentService.updateStudentById(id, updateStudent);
        return 1;
    }

    public int deleteStudentById(Long id) {
        studentService.deleteStudentById(id);
        return 1;
    }
}
