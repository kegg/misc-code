import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Vector;

public class Words {

    public static void main(String[] args) {
        Vector<String[]> vec = new Vector<>();

        String input = "continue";
        do {
            input = System.console().readLine("> ");
            vec.add(new String[]{LocalDateTime.now().toString(), input});
        } while(!input.equals(".quit"));

        vec.forEach(e->System.out.println(e[0] + " - " + e[1]));
    }

}
