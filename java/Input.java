import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.time.LocalDateTime;

public class Input {

    public static void main(String[] args) {
        System.out.println("NoteTaker v1.0");
        System.out.println(".quit to exit");
        String input;
        File file = new File("output.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, true);
            do {
                input = System.console().readLine("> ");
                if (!input.equals(".quit")) {
                    fr.write(String.format("%s - %s", LocalDateTime.now(), input));
                    fr.write("\n");
                }
            } while (!input.equals(".quit"));
        } catch (IOException e) {
        } finally {
            try {
                fr.close();
            } catch (IOException e){}
        }
    }

}
