package com.dreamsense.main;

import java.util.Scanner;

public class Help {
  public void run() {
    displayHelp();
  }

  public void displayHelp() { 
    Utils.clear();
    System.out.println("Help");
    System.out.println("======================================");
    System.out.println("q           Quit the section you're in");
    System.out.println("mail        View e-mails");
    System.out.println();

    String s;
    boolean done = false;

    Scanner input = new Scanner(System.in);

    while (!done) {
      System.out.print("Help> ");
      s = input.next();

      if (s.equals("q")) {
        done = true;
      }
    }
  }  
}
