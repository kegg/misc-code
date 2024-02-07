import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A simple application for keeping track of daily thoughts
 */
public class Thoughts {

    /**
     * The filename we're working with / saving data to
     */
    private final String filename;
    /**
     * The list where we keep all of our thoughts
     */
    private List<String> lines;

    /**
     * Our constructor, it takes the filename we're working with
     * @param filename The filename we want to save data to
     */
    public Thoughts(String filename) {
        this.filename = filename;
    }

    /**
     * Our main entry point
     * @param args The arguments passed into the program. Currently only one argument is required
     *             to run the program args[0] contains the filename we're working with.
     *             If an argument isn't provided, we supply one 'thought.txt' as the default.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[]{"thought.txt"};
        }
        Thoughts thoughts = new Thoughts(args[0]);
        thoughts.init();
        thoughts.process();
    }

    /**
     * Read in the file to a List if the file exists
     */
    private void init() {
        try {
            lines = Files.readAllLines(Paths.get(filename));
        } catch (IOException e) {
            lines = new ArrayList<>();
        }
    }

    /**
     * Here's where we do all our magic! We'll display an interface to the user,
     * which takes input and store whatever the user types into the console on
     * the screen for manipulation.
     */
    private void process() {
        String input;
        do {
            displayData(lines);
            input = Utils.readLine("%s> ", "thoughts");
            if (!Commands.getValidCommands().contains(input)) {
                input = String.format("[%s %s] %s", LocalDate.now(), LocalTime.now(), input);
                lines.add(input);
            }

            if (Commands.getValidCommands().contains(input)) {
                processCommand(input.substring(1).toUpperCase());
            }
        } while (!input.equals(Commands.QUIT.getName()));
    }

    /**
     * Do something with the valid command entered
     * @param command The command that was entered
     */
    private void processCommand(String command) {
        Commands c = Commands.valueOf(command);
        switch (c) {
            case QUIT:
                Utils.save(lines, filename);
                System.exit(0);
                break;
            case SAVE:
                Utils.save(lines, filename);
                break;
            case FILTER:
                List<String> filter = filter(lines);
                displayData(filter);
                Utils.readLine("%s","Press Enter to Continue: ");
                break;
        }
    }

    /**
     * Filter only words we want to see
     * @param lines The list of lines we're working with
     * @return A new list based on the filter
     */
    private List<String> filter(List<String> lines) {
        String word = Utils.readLine("%s%n> ", "Filter By");
        return lines.stream().filter(line->line.toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Display all the data we have in the buffer to the screen
     * @param lines The lines we're wanting to show
     */
    private void displayData(List<String> lines) {
        Utils.clear();
        Utils.print("%s%n", Utils.line());
        Utils.print("%s%n", "Thoughts");
        Utils.print("%s%n", Utils.line());
        if (lines.isEmpty()) {
            Utils.print("%s%n", "No Data To Display");
        } else {
            int i = 1;
            for (String line : lines) {
                Utils.print("%d. %s%n", i++, line);
            }
        }
        Utils.print("%s%n", Utils.line());
        Utils.print("Commands: [%s] [%s] [%s]%n",
                Commands.QUIT.getName(),
                Commands.SAVE.getName(),
                Commands.FILTER.getName());
    }

    /**
     * Available commands for the program
     */
    private enum Commands {
        /**
         * quit
         */
        QUIT(".quit"),
        /**
         * save
         */
        SAVE(".save"),
        /**
         * filter
         */
        FILTER(".filter");

        /**
         * the name of the command
         */
        private final String name;

        /**
         * Main constructor for the command
         * @param name The command the user enters
         */
        Commands(String name) {
            this.name = name;
        }

        /**
         * @return The name of the command
         */
        public String getName() {
            return this.name;
        }

        /**
         * @return A Set of valid commands
         */
        public static Set<String> getValidCommands() {
            Set<String> commands = new HashSet<>();
            Arrays.stream(Commands.values()).sequential().forEach(c->commands.add(c.getName()));
            return commands;
        }
    }

    /**
     * Some utility classes for working with the console
     */
    private static class Utils {
        /**
         * Clear the screen
         */
        public static void clear() {
            try {
                if (System.getProperty("os.name").contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                }
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        /**
         * Read input from the user
         * @param format The format to display to the user
         * @param args The arguments for the format
         * @return A String the user entered
         */
        public static String readLine(String format, Object...args) {
            if (System.console() != null) {
                return System.console().readLine(format, args).trim();
            }
            throw new RuntimeException("This JVM doesn't support the Console");
        }

        /**
         * Output a line
         * @return A line of - 80 characters long
         */
        public static String line() {
            return String.format("%80s", ' ').replace(' ', '-');
        }

        /**
         * Output data to the screen
         * @param format The format of the string we want to output
         * @param args The arguments to fill the format
         */
        public static void print(String format, Object...args) {
            System.out.printf(format, args);
        }

        /**
         * Save the lines to a file
         * @param lines The lines we're working with
         * @param filename The filename we're working with
         */
        public static void save(List<String> lines, String filename) {
            try {
                Files.write(Paths.get(filename), lines);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
