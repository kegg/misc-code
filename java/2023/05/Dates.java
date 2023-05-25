import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Dates {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDate date = LocalDate.of(2023, 01, 01);
        LocalTime time = LocalTime.of(11, 11);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(dateTime);

        System.out.printf("Is %s before %s: %s%n", now, dateTime, now.isBefore(dateTime));
        System.out.printf("Is %s after %s: %s%n", now, dateTime, now.isAfter(dateTime));

        System.out.println(now.getDayOfWeek());
        System.out.println(dateTime.getDayOfWeek());

        System.out.printf("Days in month %s: %s%n", date.getMonth(), date.lengthOfMonth());
        System.out.printf("Days in year: %s%n", date.lengthOfYear());

        System.out.printf("Date: %s%n", date);
        String MMM_DD_YYYY_FORMAT = date.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));
        System.out.printf("Date: %s%n", MMM_DD_YYYY_FORMAT);
    }
}