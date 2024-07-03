package Main.model.bl;

import Main.model.da.TeacherDa;
import Main.model.entity.Teacher;
import Main.model.tools.CRUD;
import lombok.Getter;

import java.util.List;

public class TeacherBl implements CRUD<Teacher> {
    @Getter
    public static TeacherBl studentBl=new TeacherBl();
    @Override
    public Teacher save(Teacher teacher) throws Exception {
        try (TeacherDa teacherDa=new TeacherDa()){
            teacherDa.save(teacher);
            return teacher;
        }


    }

    @Override
    public Teacher edit(Teacher teacher) throws Exception {
        return null;
    }

    @Override
    public Teacher remove(int id) throws Exception {
        return null;
    }

    @Override
    public List<Teacher> findAll() throws Exception {
        return null;
    }

    @Override
    public Teacher findById(int id) throws Exception {
        return null;
    }
}
