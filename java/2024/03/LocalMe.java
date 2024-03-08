import java.time.LocalDate;

public class LocalMe {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now().minusMonths(48);
        System.out.println(localDate);
    }
}
