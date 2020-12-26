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

@Repository("mysql")
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
        String sql = "SELECT * FROM Students WHERE id = " + id;

        ResultSetExtractor<Student> extractor = new ResultSetExtractor<Student>() {
            @Override
            public Student extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if (resultSet.next()) {
                    String firstName = resultSet.getString(1);
                    String lastName = resultSet.getString(2);
                    String grades = resultSet.getString(3);

                    return new Student(firstName, lastName, grades);
                }
                return null;
            }
        };
        return jdbcTemplate.query(sql, extractor);
    }

    @Override
    public List<Student> selectAllStudents() {
        String sql = "SELECT * FROM Students";

        RowMapper<Student> rowMapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                String firstName = resultSet.getString(1);
                String lastName = resultSet.getString(2);
                String grades = resultSet.getString(3);
                return new Student(firstName, lastName, grades);
            }
        };
        return jdbcTemplate.query(sql, rowMapper);
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
