import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Notes {

    enum Commands {
        CLEAR("Clear the note buffer"),
        HELP("Displays this help message"),
        LIST("Display the lines currently in the buffer"),
        OPEN("Open a note"),
        QUIT("Exits the program"),
        SAVE("Save a note"),
        VERSION("Show source and compiler versions");

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

        public static TreeMap<String, String> getHelp() {
            TreeMap<String, String> enums = new TreeMap<>();
            Arrays.stream(Commands.values()).forEach(e->enums.put(e.name(), e.getValue()));
            return enums;
        }
    }

    private List<String> lines;

    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.err.println("Your JVM doesn't support this application.");
            System.exit(1);
        }

        Set<String> validCommands = Commands.getEnums();

        Notes notes = new Notes();
        notes.displayProgramInfo(true);
        notes.process(validCommands, console);
    }

    private void process(Set<String> validCommands, Console console) {
        lines = new ArrayList<>();
        String input;
        do {
            input = console.readLine("%s> ", "notes");
            if (input.startsWith(".")) {
                String cmd = input.toUpperCase().substring(1);
                if (!validCommands.contains(cmd)) {
                    displayError(input);
                } else {
                    process(Commands.valueOf(cmd));
                }
            } else {
                lines.add(input);
                displayNotes();
            }
        } while (!input.equals(".quit"));
    }

    private static String center(String s) {
        final int width = 80;
        return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }

    private void displayNotes() {
        clearScreen();
        String line = String.format("%80s", ' ').replace(' ', '-');
        if (!lines.isEmpty()) {
            print("%s%n", line);
            print("%s%n", center(getWordStats()));
        }
        print("%s%n", line);
        if (!lines.isEmpty()) {
            int i = 1;
            for (String l : lines) {
                print("%d. %s%n", i++, l);
            }
        } else {
            print("No Lines To Display%n");
        }
        print("%s%n", line);
    }

    private String getWordStats() {
        String content = String.join("\n", lines);
        return String.format("Lines: %d Words: %d Chars: %d",
                lines.size() == 0 ? 0 : lines.size(),
                lines.size() == 0 ? 0 : content.split("\\s+").length,
                lines.size() == 0 ? 0 : content.replace("\n","").length());
    }

    private void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void process(Commands cmd) {
        switch(cmd) {
            case CLEAR:
                lines.clear();
                displayNotes();
                break;
            case HELP:
                displayHelp();
                break;
            case LIST:
                displayNotes();
                break;
            case OPEN:
                lines = open();
                displayNotes();
                break;
            case SAVE:
                save();
                break;
            case VERSION:
                displayProgramInfo(false);
                break;
            default:
                break;
        }
    }

    private List<String> open() {
        String filename = System.console().readLine("%s> ", "filename");
        try {
            return Files.readAllLines(Paths.get(filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void save() {
        if (lines.size() > 0) {
            String filename = System.console().readLine("%s> ", "filename");
            try {
                Files.write(Paths.get(filename), lines);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            print("There is no note content to save%n");
        }
    }

    private void displayHelp() {
        TreeMap<String, String> enums = Commands.getHelp();
        enums.forEach((k,v)->print("%-10s %s%n", "." + k.toLowerCase(), v));
    }

    private void displayError(String input) {
        print("Invalid command %s. Enter '.help' for help.%n", input);
    }

    private void displayProgramInfo(boolean help) {
        print("Notes version %.2f %s%n", 1.0, "2023-05-18");
        if (help) {
            print("Enter '.help' for usage hints.%n");
            print("Use '.open' to reopen a note file.%n");
        } else {
            print("javac 1.8.0_161%n");
        }
    }

    private void print(String format, Object...args) {
        System.out.printf(format, args);
    }
}
