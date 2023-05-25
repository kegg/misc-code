import java.text.MessageFormat;
import java.util.Formatter;
import java.util.Locale;

public class StringFormat {

    public static void main(String[] args) {
        String result = String.format("%s is %d years old.", "Fred", 47);
        System.out.println(result);

        System.out.printf("Greeting: %s%n", "Hello World!");

        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.US); // you can supply your own Locale here
        formatter.format("%s%n", "Hello World!");
        formatter.format("%s%n", "Goodbye Cruel World!");
        formatter.format("I like to eat %d times a day%n", 3);
        formatter.format("My name is %s%n", "Fred Jones");
        // and so on
        System.out.println(sb.toString());

        String messageFormat = MessageFormat.format("Hi {0}", "There!");
        System.out.println(messageFormat);
    }
}
