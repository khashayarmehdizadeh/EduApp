package Main.model.da;

import Main.model.entity.Course;
import Main.model.entity.Student;
import Main.model.entity.enums.Gender;
import Main.model.tools.CRUD;
import Main.model.tools.ConnectionProvider;
import lombok.extern.log4j.Log4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class StudentDa implements AutoCloseable, CRUD<Student> {
    private final Connection connection;
    private PreparedStatement preparedStatement;

    public StudentDa() throws SQLException {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }

    @Override
    public Student save(Student student) throws Exception {
        student.setId(ConnectionProvider.getConnectionProvider().getNextId("student_SEQ"));
        preparedStatement = connection.prepareStatement(
                "INSERT INTO STUDENT(ID, NAME, FAMILY, GENDER, BIRTHDATE, CITY, PHONENUMBER, EMAIL, ADDRESS,COURSE_ID) VALUES (?,?,?,?,?,?,?,?,?,?)"
        );
        preparedStatement.setInt(1, student.getId());
        preparedStatement.setString(2, student.getName());
        preparedStatement.setString(3, student.getFamily());
        preparedStatement.setString(4, student.getGender().name());
        preparedStatement.setDate(5, Date.valueOf(student.getBirthDate()));
        preparedStatement.setString(6, student.getCity());
        preparedStatement.setString(7, student.getPhoneNumber());
        preparedStatement.setString(8, student.getEmail());
        preparedStatement.setString(9, student.getAddress());
        preparedStatement.setInt(10,student.getCourse().getId());
        preparedStatement.execute();


        return student;
    }

    @Override
    public Student edit(Student student) throws Exception {
        preparedStatement = connection.prepareStatement(
                "UPDATE STUDENT SET NAME=?,FAMILY=?,GENDER=?,BIRTHDATE=?,CITY=?,PHONENUMBER=?,EMAIL=?,ADDRESS=?,COURSE_ID=? WHERE ID=?"
        );
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getFamily());
        preparedStatement.setString(3, student.getGender().name());
        preparedStatement.setDate(4, Date.valueOf(student.getBirthDate()));
        preparedStatement.setString(5, student.getCity());
        preparedStatement.setString(6, student.getPhoneNumber());
        preparedStatement.setString(7, student.getEmail());
        preparedStatement.setString(8, student.getAddress());
        preparedStatement.setInt(9,student.getCourse().getId());
        preparedStatement.setInt(10, student.getId());
        preparedStatement.execute();


        return student;
    }

    @Override
    public Student remove(int id) throws Exception {
        preparedStatement = connection.prepareStatement(
                "DELETE FROM STUDENT WHERE ID=?"
        );
        preparedStatement.setInt(1, id);
        preparedStatement.execute();

        return null;
    }

    @Override
    public List<Student> findAll() throws Exception {
        List<Student> studentList = new ArrayList<>();
        preparedStatement = connection.prepareStatement("SELECT *FROM STUDENT ORDER BY ID");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Student student = Student
                    .builder()
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .family(resultSet.getString("family"))
                    .gender(Gender.valueOf(resultSet.getString("gender")))
                    .birthDate(resultSet.getDate("birthDate").toLocalDate())
                    .city(resultSet.getString("city"))
                    .phoneNumber(resultSet.getString("phoneNumber"))
                    .email(resultSet.getString("email"))
                    .address(resultSet.getString("address"))
                    .course(Course.builder().name(resultSet.getString("course_id")).build())
                    .build();
            studentList.add(student);

        }

        return studentList;
    }

    @Override
    public Student findById(int id) throws Exception {
        preparedStatement = connection.prepareStatement("SELECT * FROM  STUDENT WHERE ID=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Student student = null;
        if (resultSet.next()) {
            student = Student
                    .builder()
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .family(resultSet.getString("family"))
                    .gender(Gender.valueOf(resultSet.getString("gender")))
                    .birthDate(resultSet.getDate("birthDate").toLocalDate())
                    .city(resultSet.getString("city"))
                    .phoneNumber(resultSet.getString("phoneNumber"))
                    .email(resultSet.getString("email"))
                    .address(resultSet.getString("address"))
                    .course(Course.builder().name(resultSet.getString("course_id")).build())
                    .build();
        }
        return student;
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();

    }
}
