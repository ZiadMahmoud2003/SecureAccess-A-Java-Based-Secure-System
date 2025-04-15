package loginandsignup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {




    // Method to check if the input field is empty
    public static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    // Validate email format using regular expression
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Validate password strength (at least 8 characters, 1 number, 1 uppercase, and 1 special character)
    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
