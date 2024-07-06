//package Main.test;
//
//import Main.model.bl.TeacherBl;
//import Main.model.entity.Teacher;
//import Main.model.entity.enums.Gender;
//
//import java.time.LocalDate;
//
//public class entityTest {
//    public static void main(String[] args) throws Exception {
//        Teacher teacher =
//                Teacher.builder()
//                        .id(1)
//                        .name("khashy")
//                        .family("mz")
//                        .gender(Gender.male)
//                        .birthDate(LocalDate.of(2000,10,13))
//                        .city("tehran")
//                        .phoneNumber("09120185685")
//                        .email("mzkhashayr@gmail.com")
//                        .skills("py.html")
//                        .address("test")
//
//
//
//                        .build();
//        System.out.println(TeacherBl.getTeacherBl().save(teacher));
//        System.out.println(teacher);
//    }
//}
