package Main.model.bl;

import Main.model.entity.Course;
import Main.model.tools.CRUD;
import lombok.Getter;

import java.util.List;

public class CourseBl implements CRUD<Course> {
    @Getter
    private static CourseBl courseBl=new CourseBl();
    private CourseBl(){

    }

    @Override
    public Course save(Course course) throws Exception {
        return null;
    }

    @Override
    public Course edit(Course course) throws Exception {
        return null;
    }

    @Override
    public Course remove(int id) throws Exception {
        return null;
    }

    @Override
    public List<Course> findAll() throws Exception {
        return null;
    }

    @Override
    public Course findById(int id) throws Exception {
        return null;
    }
}
