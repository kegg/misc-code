import java.nio.file.Files;
import java.nio.file.StandardOpenOption; 
import java.nio.file.Paths;
import java.io.IOException;
import java.io.File;

public class Note {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String input;
        do {
            input = System.console().readLine("> ").trim();
            if (!input.equals(".quit")) {
                sb.append(input);
                sb.append("\n");
            }
        } while (!input.equals(".quit"));
        try {
            File file = new File("file.log");
            if (!file.exists()) {
                file.createNewFile();
            }
            Files.write(Paths.get("file.log"), sb.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
        }
    }

}

