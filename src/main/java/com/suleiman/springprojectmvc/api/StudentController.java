package com.suleiman.springprojectmvc.api;

import com.suleiman.springprojectmvc.model.Student;
import com.suleiman.springprojectmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/student")
@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.insertStudent(student);
    }

    @GetMapping
    public void getAllStudents() {
        studentService.selectAllStudents();
    }

    @GetMapping(path = "{id}")
    public Student selectStudentById(@PathVariable("id") Long id) {
        return studentService.selectStudentById(id);
    }

    @PutMapping(path = "{id}")
    public void updateStudentById(@PathVariable("id") Long id, @RequestBody Student updateStudent) {
        studentService.updateStudentById(id, updateStudent);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudentById(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
    }
}
