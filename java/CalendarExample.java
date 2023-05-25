import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class CalendarExample {
    public static void main(String[] args) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Get the current month and year
        int month = currentDate.getMonthValue();
        int year = currentDate.getYear();

        // Get the first day of the month
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);

        // Get the day of the week for the first day of the month
        DayOfWeek firstDayOfWeek = firstDayOfMonth.getDayOfWeek();

        // Determine the number of days in the month
        int daysInMonth = currentDate.lengthOfMonth();

        // Print the month and year
        String monthName = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
        System.out.println(monthName + " " + year);

        // Print the calendar grid
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // Print the leading spaces
        int leadingSpaces = firstDayOfWeek.getValue() % 7;
        for (int i = 0; i < leadingSpaces; i++) {
            System.out.print("    ");
        }

        // Print the days of the month
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);

            // Move to the next line after Saturday
            if (firstDayOfWeek == DayOfWeek.SATURDAY) {
                System.out.println();
            }

            // Move to the next day
            firstDayOfWeek = firstDayOfWeek.plus(1);
        }
    }
}

