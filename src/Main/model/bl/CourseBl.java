package Main.model.bl;

import Main.controller.exceptions.NoCourseFoundException;
import Main.model.da.CourseDa;
import Main.model.entity.Course;
import Main.model.tools.CRUD;

import lombok.Getter;

import java.util.List;

public class CourseBl implements CRUD<Course> {
    @Getter
    private static CourseBl courseBl = new CourseBl();

    private CourseBl() {

    }

    @Override
    public Course save(Course course) throws Exception {
        try (CourseDa courseDa = new CourseDa()) {
            courseDa.save(course);
            return course;

        }

    }

    @Override
    public Course edit(Course course) throws Exception {
        try (CourseDa courseDa = new CourseDa()) {
            if (courseDa.findById(course.getId()) != null) {
                courseDa.edit(course);
                return course;
            } else {
                throw new NoCourseFoundException();
            }

        }

    }

    @Override
    public Course remove(int id) throws Exception {
        try (CourseDa courseDa = new CourseDa()) {
            Course course = courseDa.findById(id);
            if (course != null) {
                courseDa.remove(id);
                return course;
            } else {
                throw new NoCourseFoundException();
            }

        }

    }

    @Override
    public List<Course> findAll() throws Exception {
        try (CourseDa courseDa = new CourseDa()) {
            List<Course> courseList = courseDa.findAll();
            if (!courseList.isEmpty()) {
                return courseList;
            } else {
                throw new NoCourseFoundException();
            }


        }

    }

    @Override
    public Course findById(int id) throws Exception {
        try (CourseDa courseDa = new CourseDa()) {
            Course course = courseDa.findById(id);
            if (course != null) {
                return course;
            } else {
                throw new NoCourseFoundException();
            }

        }

    }
}
