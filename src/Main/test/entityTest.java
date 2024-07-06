package Main.test;

import Main.model.bl.CourseBl;
import Main.model.bl.StudentBl;
import Main.model.bl.TeacherBl;
import Main.model.entity.Course;
import Main.model.entity.Student;
import Main.model.entity.Teacher;
import Main.model.entity.enums.Department;
import Main.model.entity.enums.Gender;

import java.time.LocalDate;

public class entityTest {
    public static void main(String[] args) throws Exception {

        Teacher teacher = Teacher
                .builder()



                .name("john")
                .family("sins")
                .gender(Gender.male)
                .birthDate(LocalDate.of(1990, 10, 13))
                .city("tehran")
                .phoneNumber("09120185685")
                .email("mzkhashayr@gmail.com")
                .skills("py.html.java")
                .address("test")
                .build();
        System.out.println(TeacherBl.getTeacherBl().save(teacher));

        Course course =
                Course.builder()
                        .id(10)
                        .name("seo-1")
                        .department(Department.ict)
                        .info("روز های زوج")
                        .capacity(15)
                        .teacher(teacher)
                        .build();
        CourseBl.getCourseBl().save(course);
        Student student=Student.builder()
                .name("john")
                .family("sins")
                .gender(Gender.male)
                .birthDate(LocalDate.of(1990, 10, 13))
                .city("tehran")
                .phoneNumber("09120185685")
                .email("mzkhashayr@gmail.com")
                .course(course)
                .address("test")
                .build();
        StudentBl.getStudentBl().save(student);


    }
}
