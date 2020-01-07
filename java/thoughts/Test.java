import java.util.List;
import java.util.ArrayList;

public class Test {
  
  private List<Entry> thoughts;
  private List<Entry> notes;

  public Test() {

  }

  private void buildThoughts() {
    thoughts = new ArrayList<Entry>();
    thoughts.add(new Entry(DayOfWeek.MONDAY,    "2019-12-16", "10:05", TimeOfDay.AM, "What is today?"));
    thoughts.add(new Entry(DayOfWeek.MONDAY,    "2019-12-16", "01:48", TimeOfDay.PM, "Life is weird."));
    thoughts.add(new Entry(DayOfWeek.MONDAY,    "2019-12-16", "01:53", TimeOfDay.PM, "Seriously it's strange."));
    thoughts.add(new Entry(DayOfWeek.MONDAY,    "2019-12-16", "02:02", TimeOfDay.PM, "No more lies, no more hiding."));
    thoughts.add(new Entry(DayOfWeek.MONDAY,    "2019-12-16", "02:15", TimeOfDay.PM, "No one cares about you."));
    thoughts.add(new Entry(DayOfWeek.MONDAY,    "2019-12-16", "02:19", TimeOfDay.PM, "Why are you so afraid?"));
    thoughts.add(new Entry(DayOfWeek.MONDAY,    "2019-12-16", "02:23", TimeOfDay.PM, "Take a step back and breathe."));
    thoughts.add(new Entry(DayOfWeek.MONDAY,    "2019-12-16", "02:31", TimeOfDay.PM, "Maybe the future will make sense."));
    thoughts.add(new Entry(DayOfWeek.WEDNESDAY, "2019-12-18", "02:22", TimeOfDay.PM, "Perhaps life isn't meant to be this way."));
    thoughts.add(new Entry(DayOfWeek.WEDNESDAY, "2019-12-18", "02:25", TimeOfDay.PM, "Life will work out. It has to."));
    thoughts.add(new Entry(DayOfWeek.WEDNESDAY, "2019-12-18", "02:30", TimeOfDay.PM, "Living The Dream? Maybe not what it's meant to be."));
    thoughts.add(new Entry(DayOfWeek.THURSDAY,  "2019-12-19", "08:45", TimeOfDay.AM, "What is this life exactly?"));
    thoughts.add(new Entry(DayOfWeek.THURSDAY,  "2019-12-19", "11:38", TimeOfDay.AM, "Such a weird day to be alive."));
    thoughts.add(new Entry(DayOfWeek.TUESDAY,   "2020-01-07", "01:13", TimeOfDay.PM, "Meh, life can be life I'll just sit here."));
  }

  private void displayThoughts() {
    System.out.println("Thoughts");
    System.out.println("========");

    for (Entry e : thoughts) {
      System.out.printf("[%-11.11s] %s %s %s: %s\n", e.getDayOfWeek(), e.getDate(), e.getTime(), e.getTimeOfDay(), e.getContent());
    }

    System.out.println("\nTotal Records: " + thoughts.size());
  }

  private void buildNotes() {
    notes = new ArrayList<Entry>();
    notes.add(new Entry(DayOfWeek.THURSDAY, "2019-12-19", "12:34", TimeOfDay.PM, "http://www.google.com"));
  }

  private void displayNotes() {
    System.out.println("Notes");
    System.out.println("=====");

    for (Entry e : notes) {
      System.out.printf("[%-11.11s] %s %s %s: %s\n", e.getDayOfWeek(), e.getDate(), e.getTime(), e.getTimeOfDay(), e.getContent());
    }

    System.out.println("\nTotal Records: " + notes.size());
  }  

  public static void main(String[] args) {
    Test test = new Test();

    if (args.length == 1) {
      if (args[0].equals("thoughts")) {
        test.buildThoughts();
        test.displayThoughts();
      } else if (args[0].equals("notes")) {
        test.buildNotes();
        test.displayNotes();
      } else {
        test.displayInvalidCommand(args[0]);
      }
    }
  }

  private void displayInvalidCommand(String cmd) {
    System.out.printf("You didn't provide a valid command [%s].\n", cmd);
  }

  private enum TimeOfDay {
    AM,
    PM
  }

  private enum DayOfWeek {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
  }

  private class Entry {

    private String date;
    private String time;
    private String content;
    private TimeOfDay timeOfDay;
    private DayOfWeek dayOfWeek;

    public Entry(DayOfWeek dayOfWeek, String date, String time, TimeOfDay timeOfDay, String content) {
      this.dayOfWeek = dayOfWeek;
      this.date = date;
      this.time = time;
      this.timeOfDay = timeOfDay;
      this.content = content;
    }

    public String getDate() {
      return date;
    }

    public String getTime() {
      return time;
    }

    public String getDayOfWeek() {
      return dayOfWeek.toString();
    }

    public String getTimeOfDay() {
      return timeOfDay.toString();
    }

    public String getContent() {
      return content;
    }
  }
}
