import java.io.Console;
import java.time.LocalDate;
import java.time.LocalTime;

public class Menu {

    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.err.println("Console isn't supported in this JVM");
            System.exit(1);
        }

        mainMenu();

        String regex = String.format("[%d-%d]", 0, 3);
        String input;
        do {
            input = console.readLine("%s%n> ", "Enter a number from 0 to 3");

            if (!input.matches(regex)) {
                continue;
            }

            if (!input.equals("0")) {
                process(input);
                input = "-1";
            }
        } while (!input.equals("0"));
    }

    private static void process(String input) {
        int choice = Integer.parseInt(input);

        switch (choice) {
            case 1:
                System.out.println("Hello World!");
                break;
            case 2:
                LocalDate ld = LocalDate.now();
                System.out.println(ld);
                break;
            case 3:
                LocalTime lt = LocalTime.now();
                System.out.println(lt);
                break;
            default:
                break;
        }
    }

    private static void mainMenu() {
        System.out.println("Main Menu");
        System.out.println("1. Say Hello!");
        System.out.println("2. Today's Date");
        System.out.println("3. Current Time");
        System.out.println("0. Quit");
    }
}