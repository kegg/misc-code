import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Backup {

  public static void main(String[] args) {
    if (args.length == 1) {
      File file = new File(args[0]);
      
      if (file.exists()) {
        try {
          File dir = new File("archive");
          if (!dir.exists()) {
            dir.mkdirs();
          }

          Date date = new Date();
          SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
          Path source = Paths.get(args[0]);
          Path currentDir = Paths.get(args[0]);
          Path target = Paths.get(dir.getName() + "/" + file.getName() + "." + dt.format(date));          
          
          System.out.println("Backing up file: " + source.toString() + " --> " + target.toString());
          
          Files.copy(source, target);
          file.delete();
        } catch (Exception e) {
          e.printStackTrace();
        }
      } else {
        System.err.println("The file you specified '" + file.getName() +"' doesn't exist."); 
      }
    }
  }
}
