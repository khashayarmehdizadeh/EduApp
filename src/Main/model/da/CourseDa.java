package Main.model.da;

import Main.model.entity.Course;
import Main.model.entity.Teacher;
import Main.model.entity.enums.Department;
import Main.model.tools.CRUD;
import Main.model.tools.ConnectionProvider;
import lombok.extern.log4j.Log4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class CourseDa implements AutoCloseable, CRUD<Course> {
    private final Connection connection;
    private PreparedStatement preparedStatement;

    public CourseDa() throws SQLException {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }

    @Override
    public Course save(Course course) throws Exception {
        course.setId(ConnectionProvider.getConnectionProvider().getNextId("course_SEQ"));
        preparedStatement = connection.prepareStatement(
                "INSERT INTO COURSE(ID, NAME, DEPARTMENT, INFO, CAPACITY, TEACHER_ID) VALUES (?,?,?,?,?,?)"
        );
        preparedStatement.setInt(1, course.getId());
        preparedStatement.setString(2, course.getName());
        preparedStatement.setString(3, course.getDepartment().name());
        preparedStatement.setString(4, course.getInfo());
        preparedStatement.setInt(5, course.getCapacity());
        preparedStatement.setString(6, String.valueOf(course.getTeacher().getId()));
        preparedStatement.execute();
        return course;
    }

    @Override
    public Course edit(Course course) throws Exception {
        preparedStatement = connection.prepareStatement(
                "UPDATE COURSE SET NAME=?,DEPARTMENT=?,INFO=?,CAPACITY=?,TEACHER_ID=? WHERE ID=?"
        );

        preparedStatement.setString(1, course.getName());
        preparedStatement.setString(2, course.getDepartment().name());
        preparedStatement.setString(3, course.getInfo());
        preparedStatement.setInt(4, course.getCapacity());
        preparedStatement.setString(5, String.valueOf(course.getTeacher().getId()));
        preparedStatement.setInt(6, course.getId());
        preparedStatement.execute();
        return course;
    }

    @Override
    public Course remove(int id) throws Exception {
        preparedStatement = connection.prepareStatement(
                "DELETE FROM COURSE WHERE ID=?"
        );
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        return null;
    }

    @Override
    public List<Course> findAll() throws Exception {
        List<Course> courseList=new ArrayList<>();
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            Course course=Course
                    .builder()
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .department(Department.valueOf(resultSet.getString("department")))
                    .info(resultSet.getString("info"))
                    .capacity(resultSet.getInt("capacity"))
                    .teacher(Teacher.builder().id(resultSet.getInt("teacher_id")).build())
                    .build();
            courseList.add(course);
        }
        return courseList;
    }

    @Override
    public Course findById(int id) throws Exception {
        preparedStatement=connection.prepareStatement("SELECT * FROM COURSE WHERE ID=?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        Course course=null;
        if (resultSet.next()){
            course=Course
                    .builder()

                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .department(Department.valueOf(resultSet.getString("department")))
                    .info(resultSet.getString("info"))
                    .capacity(resultSet.getInt("capacity"))
                    .teacher(Teacher.builder().id(resultSet.getInt("teacher_id")).build())
                    .build();

        }
        return course;
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();

    }
}
