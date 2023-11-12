import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class ArgsContains {

    public static void main(String[] args) {
        Set arguments = new HashSet<>(Arrays.asList(args));
        if (arguments.contains("doit")) {
            System.out.println("Doing it!");
        }
    }

}
