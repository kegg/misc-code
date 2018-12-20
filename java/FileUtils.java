import java.io.File;

public class FileUtils {

  public static String getExtension(String filename) {
    String ext = null;
    
    File file = new File(filename);
    if (file.exists() && file.isFile()) {
      ext = filename.substring(filename.lastIndexOf(".") + 1);
    }
    
    return ext;
  }
  
  public static void main(String[] args) {
    System.out.println(FileUtils.getExtension(args[0]));  
  }
  
}