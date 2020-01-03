import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Test {

  public static void main(String[] args) {
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    Calendar c = new GregorianCalendar(2020, Calendar.JANUARY, 2);
    System.out.println(sdf.format(c.getTime()));
  }

}
