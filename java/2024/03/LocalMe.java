import java.util.Formatter;
import java.util.Locale;

public class LocalMe {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.ENGLISH);
        formatter.format("<%s>%s</%s>", "greeting", "Hello World", "greeting");
        System.out.println(formatter.toString());

    }
}
