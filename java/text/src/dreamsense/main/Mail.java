package com.dreamsense.main;

import java.util.Scanner;

public class Mail {

  public Mail() {}

  public void run() {
    readMail();
  }

  public void menu() {
    Utils.clear();
    System.out.println("[1] From: Fred Jones");
    System.out.println("[2] From: John Smith");
    System.out.println();
  }

  public void readMail() { 
    String s;
    boolean done = false;

    Scanner input = new Scanner(System.in);

    menu();

    while (!done) {
      System.out.print("Mail> ");
      s = input.next();

      if (s.equals("q")) {
        done = true;
      } else if (s.equals("ls")) {
        menu();
      } else {
        process(s);
      }
    }
  }  

  public void process(String s) {
    Utils.clear();

    if (s.equals("1")) {
      Email e = new Email("Fred", "Greg", "Friday's Game!")
        .addBody("Hey, arey ou coming to the game?")
        .addBody("It's on Friday, let me know.");
      System.out.println(e.getBody());
    } else if (s.equals("2")) {
      Email e = new Email("John", "Greg", "Meeting")
        .addBody("We have a meeting on Monday,")
        .addBody("will you please provide information")
        .addBody("on what you learned last week at training?")
        .addBody("Thanks,");
      System.out.println(e.getBody());
    }
  }
  
  class Email {
    private String from;
    private String to;
    private String subject;
    private String body;
    private StringBuffer sb;
    
    public Email(String from, String to, String subject) {
      this.from = from;
      this.to = to;
      this.subject = subject;
      sb = new StringBuffer();
      sb.append("From:    " + from).append("\n");
      sb.append("To:      " + to).append("\n");
      sb.append("Subject: " + subject).append("\n\n");
    }
    
    public Email addBody(String body) {
      sb.append(body)
        .append("\n");
      return this;
    }
    
    public String getBody() {
      sb.append("\n")
        .append(this.from)
        .append("\n");
      return sb.toString();
    }
  }
}
