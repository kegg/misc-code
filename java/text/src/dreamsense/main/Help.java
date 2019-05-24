package com.dreamsense.main;

import java.util.Scanner;

public class Help {
  public void run() {
    displayHelp();
  }

  public void displayHelp() { 
    Utils.clear();
    System.out.println("Help");
    System.out.println(".quit");
    System.out.println("mail");

    String s;
    boolean done = false;

    Scanner input = new Scanner(System.in);

    while (!done) {
      System.out.print("Help (.back to go back): ");
      s = input.next();

      if (s.equals(".back")) {
        done = true;
      }
    }
  }  
}
