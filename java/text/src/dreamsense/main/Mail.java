package com.dreamsense.main;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Mail {

  private Map<String, Email> emailMap = 
    new TreeMap<String, Email>(String.CASE_INSENSITIVE_ORDER);

  public Mail() {}

  private void init() {
    addEmail(new Email("1", "Fred Jones", "Greg Johnson", "Friday's Game!")
        .addBody("Hey, are you coming to the game?")
        .addBody("It's on Friday, let me know.")
        .addBody("Fred"));
    addEmail(new Email("2", "John Smith", "Greg Johnson", "Meeting")
        .addBody("We have a meeting on Monday,")
        .addBody("will you please provide information")
        .addBody("on what you learned last week at training?")
        .addBody("Thanks,")
        .addBody("John Smith"));
  }
  
  private void addEmail(Email e) {
    emailMap.put(e.getId(), e);
  }
  
  private Email getEmail(String id) {
    return emailMap.get(id);
  }

  public void run() {
    init();
    readMail();
  }

  private void menu() {
    Utils.clear();
    
    for (Map.Entry<String, Email> entry : emailMap.entrySet()) {
      System.out.printf("[%s] From: %s\n", entry.getValue().getId(), entry.getValue().getFrom());
    }
    System.out.println();
  }

  private void readMail() { 
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

  private void process(String s) {
    Utils.clear();

    if (emailMap.containsKey(s)) {
      Email email = getEmail(s);
      System.out.println(email.getBody());
    }
  }
  
  class Email {
    private String id;
    private String from;
    private String to;
    private String subject;
    private String body;
    private StringBuffer sb;
    
    public Email(String id, String from, String to, String subject) {
      this.id = id;
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
      return sb.toString();
    }
    
    public String getId() {
      return id;
    }
    
    public String getFrom() {
      return from;
    }
  }
}
