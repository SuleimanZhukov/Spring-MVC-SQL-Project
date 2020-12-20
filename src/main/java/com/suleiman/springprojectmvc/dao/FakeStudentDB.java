package com.suleiman.springprojectmvc.dao;

import com.suleiman.springprojectmvc.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fake")
public class FakeStudentDB implements StudentDao {

    private List<Student> list = new ArrayList<>();

    @Override
    public int insertStudent(Student student) {
        list.add(student);
        return 1;
    }

    @Override
    public Optional<Student> selectStudentById(Long id) {
        return list.stream().filter(student -> student.getId().equals(id)).findFirst();
    }

    @Override
    public List<Student> selectAllStudents() {
        return list;
    }

    @Override
    public int updateStudentById(Long id, Student updateStudent) {
        return 1;
    }

    @Override
    public int deleteStudentById(Long id) {
        list.remove(id);
        return 1;
    }

}
