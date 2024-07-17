package Main.test;


import Main.model.bl.StudentBl;
import Main.model.bl.TeacherBl;

import Main.model.entity.Student;
import Main.model.entity.Teacher;
import Main.model.entity.enums.City;
import Main.model.entity.enums.Course;

import Main.model.entity.enums.Gender;

import java.time.LocalDate;

public class entityTest {
    public static void main(String[] args) throws Exception {
//
//        Teacher teacher = Teacher
//                .builder()
//
//
//                .name("john")
//                .family("sins")
//                .gender(Gender.male)
//                .birthDate(LocalDate.of(1990, 10, 13))
//                .city("tehran")
//                .phoneNumber("09120185685")
//                .email("mzkhashayr@gmail.com")
//                .skills("py.html.java")
//                .address("test")
//                .course(Course.JavaSe)
//                .build();
//        System.out.println(TeacherBl.getTeacherBl().save(teacher));
//
//        Student student = Student.builder()
//                .name("john")
//                .family("sins")
//                .gender(Gender.male)
//                .birthDate(LocalDate.of(1990, 10, 13))
//                .city(City.abadan)
//                .phoneNumber("09120185685")
//                .email("mzkhashayr@gmail.com")
//                .course(Course.JavaSe)
//                .address("test")
//                .build();
//        StudentBl.getStudentBl().save(student);
//
StudentBl.getStudentBl().remove(1);
    }
}
