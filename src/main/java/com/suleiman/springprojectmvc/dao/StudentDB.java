package com.suleiman.springprojectmvc.dao;

import com.suleiman.springprojectmvc.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository("mysql")
public class StudentDB implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    public StudentDB(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

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
        return selectStudentById(id).map(student -> {
            int indexOfStudentToUpdate = list.indexOf(student);
            if (indexOfStudentToUpdate >= 0) {
                list.set(indexOfStudentToUpdate, updateStudent);
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    @Override
    public int deleteStudentById(Long id) {
        Optional<Student> studentMaybe = selectStudentById(id);
        if (studentMaybe.isEmpty()) {
            return 0;
        }
        list.remove(studentMaybe.get());
        return 1;
    }
}
