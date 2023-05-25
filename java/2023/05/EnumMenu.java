import java.io.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EnumMenu {

    enum Commands {
        HELP("Displays this help message"),
        QUIT("Exits the program"),
        VERSION("Display version info");

        private final String value;
        Commands(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

        public static Set<String> getEnums() {
            Set<String> enums = new HashSet<>();
            Arrays.stream(Commands.values()).forEach(e->enums.add(e.toString()));
            return enums;
        }
    }

    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.err.println("Your JVM doesn't support this application.");
            System.exit(1);
        }

        EnumMenu em = new EnumMenu();
        em.displayProgramInfo();

        Set<String> validCommands = Commands.getEnums();
        em.process(validCommands, console);
    }

    private void process(Set<String> validCommands, Console console) {
        String input;
        do {
            input = console.readLine("%s> ", "enum");
            if (input.startsWith(".")) {
                if (!validCommands.contains(input.toUpperCase().substring(1))) {
                    displayError(input);
                } else {
                    process(Commands.valueOf(input.toUpperCase().substring(1)));
                }
            } else {
                displayError(input);
            }
        } while (!input.equals(".quit"));
    }

    private void process(Commands cmd) {
        switch(cmd) {
            case HELP:
                System.out.println("Help!");
                break;
            case VERSION:
                System.out.println("Version!");
                break;
            case QUIT:
                System.out.println("Quit!");
                break;
            default:
                break;
        }
    }

    private void displayError(String input) {
        System.out.printf("Invalid command %s. Enter '.help' for help.%n", input);
    }

    private void displayProgramInfo() {
        System.out.println("EnumMenu version 1.0 2023-05-17");
        System.out.println("Enter '.help' for usage hints.");
    }
}
