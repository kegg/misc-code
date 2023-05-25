import java.util.*;

public class CommandLineParser {

    private Map<String, List<String>> arguments = new HashMap<>();

    public static void main(String[] args) {
        CommandLineParser commandLineParser = new CommandLineParser();
        commandLineParser.init(args);
        commandLineParser.run();
    }

    private void run() {
        if (CommandLineArgs.HELP.isSet(arguments)) {
            String helpText = EnumUtils.getEnumAsString(CommandLineArgs.class);
            System.out.println(helpText);
            System.exit(0);
        }

        if (CommandLineArgs.FILES.isSet(arguments)) {
            List<String> params = CommandLineArgs.FILES.getParameters(arguments);

            if (params.size() > 0) {
                params.forEach(System.out::println);
            }
        }
    }

    private void init(String[] args) {
        try {
            Set<String> validArgs = CommandLineArgs.getValidArgs();
            arguments = Args.parseArgs(args, validArgs);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    enum CommandLineArgs {
        HELP("-?, -h, -help", "Displays this general help message"),
        FILES("-f, -files", "Work with files"),
        VERSION("-v, -version", "Displays the version info and exits");

        private final String value;
        private final String description;

        CommandLineArgs(String value, String description) {
            this.value = value;
            this.description = description;
        }

        public String getValue() {
            return this.value;
        }

        public String getDescription() {
            return this.description;
        }

        public boolean isSet(Map<String, List<String>> map) {
            for (String s : getArgs()) {
                if (map.containsKey(s.trim())) {
                    return true;
                }
            }
            return false;
        }

        public static Set<String> getValidArgs() {
            Set<String> set = new HashSet<>();

            for (CommandLineArgs args : CommandLineArgs.values()) {
                for (String a : args.getArgs()) {
                    set.add(a.trim());
                }
            }
            return set;
        }

        public String[] getArgs() {
            return this.value.split(",");
        }

        public List<String> getParameters(Map<String, List<String>> map) {
            for (String s : getArgs()) {
                if (map.containsKey(s.trim())) {
                    return map.get(s.trim());
                }
            }
            return new ArrayList<>();
        }

        @Override
        public String toString() {
            return String.format("  %-20s %s", getValue().replace(",", ""), getDescription());
        }
    }

    static class Args {

        public static Map<String, List<String>> parseArgs(String[] args, Set<String> validArgs) {
            Map<String, List<String>> map = new HashMap<>();

            List<String> options = null;

            for (String a : args) {
                if (a.charAt(0) == '-') {
                    if (a.length() < 2) {
                        throw new IllegalArgumentException("Invalid Argument: " + a);
                    }
                    if (!validArgs.contains(a)) {
                        throw new IllegalArgumentException("Invalid Argument: " + a);
                    }
                    options = new ArrayList<>();
                    map.put(a, options);
                } else if (options != null) {
                    options.add(a);
                } else {
                    throw new IllegalArgumentException("Invalid Argument: " + a);
                }
            }
            return map;
        }
    }

    static class EnumUtils {

        public static <T extends Enum<T>> String getEnumAsString(Class<T> clazz) {
            if (!clazz.isEnum()) {
                throw new IllegalArgumentException("The passed class is not an enum.");
            }

            T[] types = clazz.getEnumConstants();
            StringBuilder sb = new StringBuilder();
            Iterator<T> iterator = Arrays.stream(types).iterator();

            while (iterator.hasNext()) {
                T type = iterator.next();
                sb.append(type);
                if (iterator.hasNext()) {
                    sb.append("\n");
                }
            }
            return sb.toString();
        }
    }
}
