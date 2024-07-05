package Main.model.bl;

import Main.controller.exceptions.NoTeachertFoundException;
import Main.model.da.TeacherDa;
import Main.model.entity.Teacher;
import Main.model.tools.CRUD;
import lombok.Getter;

import java.util.List;

public class TeacherBl implements CRUD<Teacher> {
    @Getter
    public static TeacherBl studentBl = new TeacherBl();

    @Override
    public Teacher save(Teacher teacher) throws Exception {
        try (TeacherDa teacherDa = new TeacherDa()) {
            teacherDa.save(teacher);
            return teacher;
        }


    }

    @Override
    public Teacher edit(Teacher teacher) throws Exception {
        try (TeacherDa teacherDa = new TeacherDa()) {
            if (teacherDa.findById(teacher.getId()) != null) {
                teacherDa.edit(teacher);
                return teacher;
            } else {
                throw new NoTeachertFoundException();
            }

        }

    }

    @Override
    public Teacher remove(int id) throws Exception {
        try (TeacherDa teacherDa = new TeacherDa()) {
            Teacher teacher = teacherDa.findById(id);
            if (teacher != null) {
                teacherDa.remove(id);
                return teacher;
            } else {
                throw new NoTeachertFoundException();
            }

        }
    }

    @Override
    public List<Teacher> findAll() throws Exception {
        try (TeacherDa teacherDa = new TeacherDa()) {
            List<Teacher> teacherList = teacherDa.findAll();
            if (!teacherList.isEmpty()) {
                return teacherList;
            } else {
                throw new NoTeachertFoundException();
            }

        }

    }

    @Override
    public Teacher findById(int id) throws Exception {
        try (TeacherDa teacherDa = new TeacherDa()) {
            Teacher teacher = teacherDa.findById(id);
            if (teacher != null) {
                return teacher;
            } else {
                throw new NoTeachertFoundException();
            }

        }

    }
}
