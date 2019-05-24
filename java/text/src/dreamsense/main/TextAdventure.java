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

    System.out.println("Text Adventure v1.0");
    System.out.println("===================");
    System.out.println(".help for Help     ");
    System.out.println();

    while (!done) {
      System.out.print("> ");
      s = input.next();

      if (s.equals(".quit")) {
        done = true;
      } else if (s.equals(".help")) {
        new Help().run();
      } else {
        process(s);
      }
      Utils.clear();
    }
  }

  public void process(String s) {
    switch (s) {
      case "mail":
        new Mail().run();
      break;
    }
  }

  public static void main(String[] args) {
    TextAdventure ta = new TextAdventure();
    ta.init();
    ta.run();
  }

}
