package Main.model.da;

import Main.model.entity.Student;
import Main.model.tools.CRUD;
import Main.model.tools.ConnectionProvider;
import lombok.extern.log4j.Log4j;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Log4j
public class StudentDa implements AutoCloseable, CRUD<Student> {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    public StudentDa()throws SQLException{
        connection= ConnectionProvider.getConnectionProvider().getConnection();
    }
    @Override
    public Student save(Student student) throws Exception {
        student.setId(ConnectionProvider.getConnectionProvider().getNextId("student_SEQ"));
        preparedStatement=connection.prepareStatement(
          "INSERT INTO STUDENT(ID, NAME, FAMILY, GENDER, BIRTHDATE, CITY, PHONENUMBER, EMAIL, ADDRESS) VALUES (?,?,?,?,?,?,?,?,?)"
        );
        preparedStatement.setInt(1,student.getId());
        preparedStatement.setString(2,student.getName());
        preparedStatement.setString(3,student.getFamily());
        preparedStatement.setString(4,student.getGender().name());
        preparedStatement.setDate(5, Date.valueOf(student.getBirthDate()));
        preparedStatement.setString(6,student.getCity());
        preparedStatement.setString(7,student.getPhoneNumber());
        preparedStatement.setString(8,student.getEmail());
        preparedStatement.setString(9,student.getAddress());
        preparedStatement.execute();


        return student;
    }

    @Override
    public Student edit(Student student) throws Exception {
        preparedStatement=connection.prepareStatement(
                "UPDATE STUDENT SET NAME=?,FAMILY=?,GENDER=?,BIRTHDATE=?,CITY=?,PHONENUMBER=?,EMAIL=?,ADDRESS=? WHERE ID=?"
        );
        return null;
    }

    @Override
    public Student remove(Student student) throws Exception {
        return null;
    }

    @Override
    public List<Student> findAll(Student student) throws Exception {
        return null;
    }

    @Override
    public Student findById(int id) throws Exception {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
