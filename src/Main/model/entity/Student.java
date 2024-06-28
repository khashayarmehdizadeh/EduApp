package Main.model.entity;

import Main.model.entity.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Student {
    private int id;
    private String name;
    private String family;
    private Gender gender;
    private LocalDate birthDate;
    private String city;
    private String phoneNumber;
    private String address;


}
