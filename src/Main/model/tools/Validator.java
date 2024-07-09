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

    public static String emailValidator(String email, String message) throws Exception {
        if (Pattern.matches("\\w*\\.*\\w*\\@(gmail|yahoo).com", email)) {
            return email;
        } else {
            throw new Exception(message);
        }
    }

    public static String phoneValidator(String phone, String message) throws Exception {
        if (Pattern.matches("09\\d{10}|\\+98\\d{10}", phone)) {
            return phone;
        } else {
            throw new Exception(message);
        }
    }
}
