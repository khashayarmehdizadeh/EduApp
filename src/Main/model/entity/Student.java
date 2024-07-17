package Main.model.entity;

import Main.model.entity.enums.City;
import Main.model.entity.enums.Course;
import Main.model.entity.enums.Gender;
import com.google.gson.Gson;
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
    private City city;
    private String phoneNumber;
    private String email;
    private String address;
    private Course course;



    @Override
    public String toString() {
        return new Gson().toJson(this);
    }


}
