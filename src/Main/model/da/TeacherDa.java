package Main.model.da;


import Main.model.entity.Student;
import Main.model.entity.Teacher;
import Main.model.entity.enums.Gender;
import Main.model.entity.enums.City;
import Main.model.tools.CRUD;
import Main.model.tools.ConnectionProvider;
import lombok.extern.log4j.Log4j;
import Main.model.entity.enums.Course;
import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class TeacherDa implements AutoCloseable, CRUD<Teacher> {
    private final Connection connection;
    private PreparedStatement preparedStatement;

    public TeacherDa() throws SQLException {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }

    @Override
    public Teacher save(Teacher teacher) throws Exception {
        teacher.setId(ConnectionProvider.getConnectionProvider().getNextId("teacher_SEQ"));
        preparedStatement = connection.prepareStatement(
                "INSERT INTO TEACHER(ID, NAME, FAMILY, GENDER, BIRTHDATE, CITY, PHONENUMBER, EMAIL, SKILLS, ADDRESS,COURSE) VALUES (?,?,?,?,?,?,?,?,?,?,?)"
        );
        preparedStatement.setInt(1, teacher.getId());
        preparedStatement.setString(2, teacher.getName());
        preparedStatement.setString(3, teacher.getFamily());
        preparedStatement.setString(4, teacher.getGender().name());
        preparedStatement.setDate(5, Date.valueOf(teacher.getBirthDate()));
        preparedStatement.setString(6, teacher.getCity().name());
        preparedStatement.setString(7, teacher.getPhoneNumber());
        preparedStatement.setString(8, teacher.getEmail());
        preparedStatement.setString(9, teacher.getSkills());
        preparedStatement.setString(10, teacher.getAddress());
        preparedStatement.setString(11,teacher.getCourse().name());
        preparedStatement.execute();
        return teacher;
    }

    @Override
    public Teacher edit(Teacher teacher) throws Exception {
        preparedStatement = connection.prepareStatement(
                "UPDATE TEACHER SET NAME=?,FAMILY=?,GENDER=?,BIRTHDATE=?,CITY=?,PHONENUMBER=?,EMAIL=?,SKILLS=?,ADDRESS=?,COURSE=? WHERE ID=?"
        );

        preparedStatement.setString(1, teacher.getName());
        preparedStatement.setString(2, teacher.getFamily());
        preparedStatement.setString(3, teacher.getGender().name());
        preparedStatement.setDate(4, Date.valueOf(teacher.getBirthDate()));
        preparedStatement.setString(5, teacher.getCity().name());
        preparedStatement.setString(6, teacher.getPhoneNumber());
        preparedStatement.setString(7, teacher.getEmail());
        preparedStatement.setString(8, teacher.getSkills());
        preparedStatement.setString(9, teacher.getAddress());
        preparedStatement.setString(10,teacher.getCourse().name());
        preparedStatement.setInt(11, teacher.getId());
        preparedStatement.execute();
        return teacher;
    }

    @Override
    public Teacher remove(int id) throws Exception {
        preparedStatement = connection.prepareStatement(
                "DELETE FROM TEACHER WHERE ID=?"
        );
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        return null;
    }

    @Override
    public List<Teacher> findAll() throws Exception {
        List<Teacher> teacherList = new ArrayList<>();
        preparedStatement = connection.prepareStatement("SELECT * FROM TEACHER ORDER BY ID");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Teacher teacher = Teacher
                    .builder()
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .family(resultSet.getString("family"))
                    .gender(Gender.valueOf(resultSet.getString("gender")))
                    .birthDate(resultSet.getDate("birthDate").toLocalDate())
                    .city(City.valueOf(resultSet.getString("city")))
                    .phoneNumber(resultSet.getString("poneNumber"))
                    .email(resultSet.getString("email"))
                    .skills(resultSet.getString("skills"))
                    .address(resultSet.getString("address"))
                    .course(Course.valueOf(resultSet.getString("course")))

                    .build();
            teacherList.add(teacher);
        }
        return teacherList;
    }

    @Override
    public Teacher findById(int id) throws Exception {
        preparedStatement = connection.prepareStatement("SELECT *FROM TEACHER WHERE ID=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Teacher teacher = null;
        if (resultSet.next()) {
            teacher = Teacher
                    .builder()
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .family(resultSet.getString("family"))
                    .gender(Gender.valueOf(resultSet.getString("gender")))
                    .birthDate(resultSet.getDate("birthDate").toLocalDate())
                    .city(City.valueOf(resultSet.getString("city")))
                    .phoneNumber(resultSet.getString("poneNumber"))
                    .email(resultSet.getString("email"))
                    .skills(resultSet.getString("skills"))
                    .address(resultSet.getString("address"))
                    .course(Course.valueOf(resultSet.getString("course")))



                    .build();
        }
        return teacher;
    }
    public List<Teacher> findByFamily(String family) throws SQLException {
        List<Teacher> teacherList = new ArrayList<>();
        preparedStatement = connection.prepareStatement("SELECT * FROM  STUDENT WHERE FAMILY LIKE ? ORDER BY ID");
        preparedStatement.setString(1,family+"%");
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            Teacher teacher=Teacher
                    .builder()
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .family(resultSet.getString("family"))
                    .gender(Gender.valueOf(resultSet.getString("gender")))
                    .birthDate(resultSet.getDate("birthDate").toLocalDate())
                    .city(City.valueOf(resultSet.getString("city")))
                    .phoneNumber(resultSet.getString("poneNumber"))
                    .email(resultSet.getString("email"))
                    .skills(resultSet.getString("skills"))
                    .address(resultSet.getString("address"))
                    .course(Course.valueOf(resultSet.getString("course")))



                    .build();
            teacherList.add(teacher);
        }
        return teacherList;
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();

    }
}
