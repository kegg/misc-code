package com.dreamsense.console;

/**
 * Methods to check that certain values are of a certain type
 */
public final class CheckValue {

    /**
     * Can't instantiate this class
     */
    private CheckValue() {}

    /**
     * Check if a value is a double
     * @param input The value to check
     * @return true if the value can be interpreted as a double, false if it can't
     */
    public static boolean isDouble(String input) {
        if (input == null || input.trim().isEmpty()) return false;
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    /**
     * Check if a value is an integer
     * @param input The value to check
     * @return true if the value can be interpreted as an integer, false if it can't
     */
    public static boolean isInteger(String input) {
        if (input == null || input.trim().isEmpty()) return false;
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Check if a value is a float
     * @param input The value to check
     * @return true if the value can be interpreted as a float, false if it can't
     */
    public static boolean isFloat(String input) {
        if (input == null || input.trim().isEmpty()) return false;
        try {
            Float.parseFloat(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Check if a value is a char
     * @param input The value to check
     * @return true if the value can be interpreted as a char, false if it can't
     */
    public static boolean isChar(String input) {
        if (input == null || input.trim().isEmpty() || input.length() > 1) return false;
        try {
            input.charAt(0);
        } catch (StringIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }
}

