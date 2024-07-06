//package Main.test;
//
//import Main.model.bl.TeacherBl;
//import Main.model.entity.Course;
//import Main.model.entity.Teacher;
//import Main.model.entity.enums.Gender;
//
//import java.time.LocalDate;
//
//public class TeacherTest {
//    public static void main(String[] args) throws Exception {
//
//        Teacher teacher=Teacher.builder()
//
//
//                .id(10)
//                .name("khashayar")
//                .family("jafari")
//                .gender(Gender.male)
//                .birthDate(LocalDate.of(1990,10,13))
//                .city("tehran")
//                .phoneNumber("09120185685")
//                .email("mzkhashayr@gmail.com")
//                .skills("py.html.java")
//                .address("test")
//                .course(new Course(.getId(22)))
//                .build();
//        TeacherBl.getTeacherBl().save(teacher);
//        System.out.println("saved");
//    }
//}
