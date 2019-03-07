import java.security.InvalidParameterException;

public class Validator {
    public static void validateName(String name) {
        if (name == null || name.trim().equals("") || name.trim().equals(" ") || name.equals("") || name.equals(" ")) {
            throw new InvalidParameterException("Name cannot be empty");
        }
    }

    public static void validateMoney(double money) {
        if (money < 0) {
            throw new InvalidParameterException("Money cannot be negative");
        }
    }
}
