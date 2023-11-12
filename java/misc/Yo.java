import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Yo {

  public static void main(String[] args) throws IOException {
    FileWriter fw = new FileWriter("file.txt", true);
    PrintWriter pw = new PrintWriter(fw);
    
    pw.print("Hello World!");
    pw.println();
    pw.close();
  }
}
