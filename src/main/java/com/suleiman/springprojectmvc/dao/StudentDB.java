package com.suleiman.springprojectmvc.dao;

import com.suleiman.springprojectmvc.model.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("postgres")
public class StudentDB implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    public StudentDB(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int insertStudent(Student student) {
        String sql = "INSERT INTO Students (firstName, lastName, grades) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, student.getFirstName(), student.getLastName(), student.getGrades());
    }

    @Override
    public Student selectStudentById(Long id) {
        final String sql = "SELECT id, firstname, lastname, grades FROM Students WHERE id = " + id;
        return jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString("lastname");
            String grades = resultSet.getString("grades");
            return new Student(id, firstname, lastname, grades);
        });
//        ResultSetExtractor<Student> extractor = new ResultSetExtractor<Student>() {
//            @Override
//            public Student extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//                if (resultSet.next()) {
//                    String firstName = resultSet.getString(1);
//                    String lastName = resultSet.getString(2);
//                    String grades = resultSet.getString(3);
//
//                    return new Student(firstName, lastName, grades);
//                }
//                return null;
//            }
//        };
//        return jdbcTemplate.queryFor(sql, extractor);
    }

    @Override
    public List<Student> selectAllStudents() {
        final String sql = "SELECT id, firstname, lastname, grades FROM student";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Long id = resultSet.getLong("id");
            String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString("lastname");
            String grades = resultSet.getString("grades");
            return new Student(id, firstname, lastname, grades);
        });
    }

    @Override
    public int updateStudentById(Long id, Student updateStudent) {
        String sql = "UPDATE Students SET (firstName, lastName, grades) VALUES (?, ?, ?) WHERE id = " + id;
        return jdbcTemplate.update(sql, updateStudent.getFirstName(), updateStudent.getLastName(), updateStudent.getGrades());
    }

    @Override
    public int deleteStudentById(Long id) {
        String sql = "DELETE FROM Students WHERE id = " + id;
        return jdbcTemplate.update(sql);
    }
}
