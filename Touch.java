import java.io.File;
import java.io.IOException;

public class Touch {

  public static void main(String[] args) throws IOException {
    if (args.length == 1) {
      File file = new File(args[0]);
      if (file.exists()) {
        file.setLastModified(System.currentTimeMillis());
      } else {
        file.createNewFile();    
      }
    }
  }

}