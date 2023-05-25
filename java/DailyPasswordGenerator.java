import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DailyPasswordGenerator {
    
    public static void main(String[] args) {
        
        // set the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        
        // get today's date as string
        String date = LocalDate.now().format(formatter);
        
        // generate a secure random password
        String password = generatePassword(date);
        
        // print the password
        System.out.println("Today's password is: " + password);
    }
    
    public static String generatePassword(String seed) {
        
        // create a secure random object with seed
        SecureRandom random = new SecureRandom(seed.getBytes());
        
        // define the characters that can be used in the password
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        
        // generate a random password of length 8
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        
        // return the password as string
        return sb.toString();
    }
}

