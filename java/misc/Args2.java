import java.util.ArrayList;
import java.util.List;

public class Args2 {
    /** convenient "-flag opt" combination */
    static class Option {
        String flag, opt;
        public Option(String flag, String opt) { this.flag = flag; this.opt = opt; }
    }

    public static void main(String[] args) {
        List<String> argsList = new ArrayList<>();
        List<Option> optsList = new ArrayList<>();
        List<String> doubleOptsList = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            if (args[i].charAt(0) == '-') {
                if (args[i].length() < 2)
                    throw new IllegalArgumentException("Not a valid argument: " + args[i]);
                if (args[i].charAt(1) == '-') {
                    if (args[i].length() < 3)
                        throw new IllegalArgumentException("Not a valid argument: " + args[i]);
                    // --opt
                    doubleOptsList.add(args[i].substring(2, args[i].length()));
                } else {
                    if (args.length - 1 == i)
                        throw new IllegalArgumentException("Expected arg after: " + args[i]);
                    // -opt
                    optsList.add(new Option(args[i], args[i + 1]));
                    i++;
                }
            } else {// arg
                argsList.add(args[i]);
            }
        }
        // etc
    }
}
