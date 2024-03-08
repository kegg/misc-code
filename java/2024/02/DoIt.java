import java.time.LocalDateTime;

public class DoIt {

    public static void main(String[] args) {
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
        System.out.println(yesterday);
    }
}
