import java.io.IOException;

public class Thinking {

  public Thinking() {
  
  }

  private static String OS = System.getProperty("os.name").toLowerCase();  
  
  private static String[] thoughts = {
    "Don't think after it's too late. You'll never know what's going on.",
    "To be known of man is to be understood by no one.",
    "What is life if we are but actors?",
    "To understand wisdom, is the beginning of learning.",
    "Once you realize you are nothing, then you are able to understand.",
    "Putting yourself before others is not a noble act.",
    "If you have half a truth, you do not contain the truth.",
    "A lie of omission is still a lie.",
    "A piece of gold in the hand and a goat is worth the goat.",
    "Riches will take you nowhere.",
    "Life has the ability to destroy you.",
    "Time will fail you eventually.",
    "A wise man can be foolish, a foolish man can be wise.",
    "To be honest with yourself is to be honest with man.",
    "Don't look behind you when you want to move forward.",
    "Life has a way, it's not always your way, but it has a way.",
    "If there's a better plan than the path you're on, take it."

  };
  
  private void process(String[] whatToOutput) {
    int i = 1;
    
    for (String line : whatToOutput) {
      String n = i + ". ";
      if (whatToOutput.length > 9 && i < 10) {
        n = "0" + n;
      }
      System.out.print(n);
      System.out.println(line);
      i++;
    }
  }
  
  public void clear() {
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
  
  public boolean isWindows() {
    return (OS.indexOf("win") >= 0);
  }  
  
  public void header() {
    System.out.println("+--------------------------------------+");
    System.out.println("|            Thoughts Of Me            |");
    System.out.println("+--------------------------------------+");    
  }
  
  public void help() {
    header();
    System.out.println("");
    System.out.println("  This is a small collection of thoughts");
    System.out.println("which I have compiled over the years. It");
    System.out.println("is nothing too comprehensive. Just a fun");
    System.out.println("project I came up with.                 ");
    System.out.println("");    
    System.out.println("                          Kyle Eggleston");
    System.out.println("                            May 18, 2018");
    System.out.println("");
  }
  
  public static void main(String[] args) {
    Thinking think = new Thinking();
    think.clear();
    
    if (args.length == 1) {
      if (args[0].equals("--help")) {
        think.help();
      }
    } else {
      think.header();
      think.process(thoughts);
    }
  }

}
