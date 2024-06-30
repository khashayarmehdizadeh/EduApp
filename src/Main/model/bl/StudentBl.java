package Main.model.bl;

import Main.model.entity.Student;
import Main.model.tools.CRUD;
import lombok.Getter;

import java.util.List;

public class StudentBl implements CRUD<Student> {
    @Getter
    private static StudentBl studentBl=new StudentBl();
    private StudentBl(){

    }
    @Override
    public Student save(Student student) throws Exception {
        try (){

        }
        return null;
    }

    @Override
    public Student edit(Student student) throws Exception {
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
}
