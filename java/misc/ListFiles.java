import java.io.File;
import java.text.SimpleDateFormat;

public class ListFiles {

  public static void main(String[] args) {
    File folder = new File(".");
    File[] listOfFiles = folder.listFiles();
    
    System.out.println("Name\t\tModified\t\tSize");
    
    for (File file : listOfFiles) {
      if (file.isFile()) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        System.out.print(file.getName());
        System.out.print("\t");
        System.out.print(sdf.format(file.lastModified()));
        System.out.print("\t");
        System.out.println(file.length());
      }
    }
  }

}