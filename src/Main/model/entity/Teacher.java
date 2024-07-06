package Main.model.entity;

import Main.model.entity.enums.Gender;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Setter
@SuperBuilder
public class Teacher {
    private int id;
    private String name;
    private String family;
    private Gender gender;
    private LocalDate birthDate;
    private String city;
    private String phoneNumber;
    private String email;
    private String skills;
    private String address;



    @Override
    public String toString() {
        return new Gson().toJson(this);
    }


}
