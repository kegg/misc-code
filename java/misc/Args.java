package com.dreamsense.arguments;

import java.util.*;

public final class Args {

    /**
     * Can't instantiate this class.
     */
    private Args() {}

    /**
     * Prepare the arguments passed in the commandline and put them in a map.
     *
     * @param args    The arguments passed in via the commandline
     * @param validArgs  A Set of valid arguments for this program that we'll compare against
     * @return A map containing all the arguments and their assigned values
     * @throws IllegalArgumentException if the argument is invalid
     */
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
