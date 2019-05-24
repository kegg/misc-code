package com.dreamsense.main;

import java.util.Scanner;

public class TextAdventure {

  public TextAdventure() {

  }

  public void init() {
    Utils.clear();
  }

  public void run() {
    String s;
    boolean done = false;

    Scanner input = new Scanner(System.in);

    while (!done) {
      System.out.print("Command: ");
      s = input.next();

      if (s.equals(".quit")) {
        done = true;
      } else {
        process(s);
      }
    }
  }

  public void process(String s) {
    System.out.println(s);
  }

  public static void main(String[] args) {
    TextAdventure ta = new TextAdventure();
    ta.init();
    ta.run();
  }

}
