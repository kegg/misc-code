package com.dreamsense.main;

import java.io.IOException;

public class Utils {

  private static String OS = System.getProperty("os.name").toLowerCase(); 

  private static boolean isWindows() {
    return (OS.indexOf("win") >= 0);
  }  

  public static void clear() {
  	if (isWindows()) {
  	  try {
  	    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
  	  } catch (IOException ioe) {
  	    System.out.println("Error: " + ioe);
  	  } catch (InterruptedException ie) {
  	    System.out.println("Error: " + ie);
  	  }
  	} else {
  	  System.out.print("\033[H\033[2J");  
      System.out.flush();
    }
  }

}
