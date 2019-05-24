package com.dreamsense.main;

import java.util.Scanner;

public class Mail {

  public Mail() {}

  public void run() {
    readMail();
  }

  private String email1 = "From: Fred Jones";

  public void menu() {
    System.out.println("[1] From: Fred Jones");
    System.out.println("[2] From: John Smith");
  }

  public void readMail() { 
    Utils.clear();

    String s;
    boolean done = false;

    Scanner input = new Scanner(System.in);

    while (!done) {
      menu();
      System.out.print("Mail: ");
      s = input.next();

      if (s.equals(".back")) {
        done = true;
      } else {
        process(s);
      }
    }
  }  

  public void process(String s) {
    Utils.clear();

    if (s.equals("1")) {
      System.out.println(email1);
    }
  }
}
