package Main.model.entity;

import Main.model.entity.enums.Department;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;



@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Course {
    private int id;
    private String name;
    private Department department;
    private String info;
    private int capacity;
    private Teacher teacher;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }


}
