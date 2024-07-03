package Main.model.bl;

import Main.controller.exceptions.NoStudentFoundException;
import Main.model.da.StudentDa;
import Main.model.entity.Student;
import Main.model.tools.CRUD;
import lombok.Getter;

import java.util.List;

public class StudentBl implements CRUD<Student> {
    @Getter
    private static StudentBl studentBl = new StudentBl();

    private StudentBl() {

    }

    @Override
    public Student save(Student student) throws Exception {
        try (StudentDa studentDa = new StudentDa()) {
            studentDa.save(student);
            return student;


        }
    }

    @Override
    public Student edit(Student student) throws Exception {
        return null;
    }

    @Override
    public Student remove(int id) throws Exception {
        try (StudentDa studentDa = new StudentDa()) {
            Student student = studentDa.findById(id);
            if (student != null) {
                studentDa.remove(id);
                return student;

            } else {
                throw new NoStudentFoundException();
            }

        }

    }

    @Override
    public List<Student> findAll(Student student) throws Exception {
        return null;
    }

    @Override
    public Student findById(int id) throws Exception {
        return null;
    }
}
