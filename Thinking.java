public class Thinking {

  public Thinking() {
  
  }
  
  private static String[] thoughts = {
    "Don't think after it's too late. You'll never know what's going on.",
    "To be known of man is to be understood by no one.",
    "What is life if we are but actors?",
    "To understand wisdom, is the beginning of learning.",
    "Once you realize you are nothing, then you are able to understand.",
    "Putting yourself before others is not a noble act.",
    "If you have half a truth, you do not contain the truth.",
    "A lie of omission is still a lie."
  };
  
  private void process(String[] whatToOutput) {
    int i = 1;
    
    for (String line : whatToOutput) {
      System.out.print(i + ". ");
      System.out.println(line);
      i++;
    }
  }
  
  public void clear() {
    System.out.print("\033[H\033[2J");  
    System.out.flush();       
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