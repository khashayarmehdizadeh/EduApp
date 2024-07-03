//package Main.test;
//
//import Main.model.bl.StudentBl;
//import Main.model.entity.Student;
//import Main.model.entity.enums.Gender;
//
//import java.time.LocalDate;
//
//public class entityTest {
//    public static void main(String[] args) throws Exception {
//      Student student =
//               Student.builder()
//                        .id(1)
//                        .name("khashayar")
//                        .family("mehdizadeh")
//                        .gender(Gender.male)
//                        .birthDate(LocalDate.of(2000, 7, 13))
//                        .city("tehran")
//                        .phoneNumber("09120185685")
//                        .address("saadat abad")
//
//
//                        .build();
//        System.out.println(StudentBl.getStudentBl().save(student));
//        System.out.println(student);
//    }
//}
