import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.Date;

public class Log {

  private static FileHandler fileTxt;
  
  public static void main(String[] args) throws IOException {
    if (args.length == 1) {
      Logger logger = Logger.getLogger(Log.class.getName());
      logger.setUseParentHandlers(false);
      fileTxt = new FileHandler("logit.txt", true);

      Formatter formatter = new Formatter() {
        @Override
        public String format(LogRecord arg0) {
          StringBuilder b = new StringBuilder();
          b.append(new Date());
          b.append(" ");
          //b.append(arg0.getSourceClassName());
          //b.append(" ");
          //b.append(arg0.getSourceMethodName());
          //b.append(" ");
          //b.append(arg0.getLevel());
          //b.append(" ");
          b.append(arg0.getMessage());
          b.append(System.getProperty("line.separator"));
          return b.toString();
        }
      };      
      
      fileTxt.setFormatter(formatter);
      logger.addHandler(fileTxt);      
      logger.log(Level.INFO, args[0]);
    }
    
  }

}