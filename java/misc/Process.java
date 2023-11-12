import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Process {

  public static void main(String[] args) {
    SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd, yyyy");

    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();


    headerFooter();

    for (int i = 1; i < 4; i++) {
      System.out.print("|");

      if (i == 1) {
        for (int l = 1; l < 62; l++) {
          System.out.print(" ");
        }

        System.out.print(formatter.format(new Date()));

        System.out.print(" ");
      } else if (i == 3) {
        System.out.print(" ");

        System.out.print(input);

        for (int k = 1; k < 62 - input.length(); k++) {
          System.out.print(" ");
        }

        System.out.print(" Kyle Eggleston ");
      } else {
        for (int j = 1; j < 79; j++) {
          System.out.print(" ");
        }
      }

      System.out.println("|");
    }

    headerFooter();

  }

  public static void headerFooter() {

    System.out.print("+");
 
    for (int i = 1; i < 79; i++) {
      System.out.print("-");
    }
 
    System.out.println("+");

  }

}
