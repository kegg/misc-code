import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyPassword {
    public static boolean verifyPassword(String password) {
        // Password requirements:
        // At least 8 characters
        // Contains at least one lowercase letter
        // Contains at least one uppercase letter
        // Contains at least one digit
        // Contains at least one special character

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

    public static void main(String[] args) {
        String password = args[0];
        boolean isValid = verifyPassword(password);
        System.out.println("Is password valid? " + isValid);
    }
}
