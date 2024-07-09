package Main.model.tools;

import java.util.regex.Pattern;

public class Validator {
    public static String nameValidator(String name, String message) throws Exception {
        if (Pattern.matches("^[a=zA-z\\s]{3,30}$", name)) {
            return name;
        } else {
            throw new Exception(message);

        }
    }
}
