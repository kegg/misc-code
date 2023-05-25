public class Collatz {

  public static void main(String[] args) {
    int i = Integer.valueOf(args[0]);
    int attempts = 0;

    System.out.println(i);

    while (i != 1) {
      OddOrEven oddOrEven = oddOrEven(i);

      if (oddOrEven == OddOrEven.EVEN) {
        i = i / 2;
      } else if (oddOrEven == OddOrEven.ODD) {
        i = (i * 3) + 1;
      }

      System.out.println(i);

      attempts++;
    }
    System.out.format("This attempt took %d tries%n", attempts);
  }

  public static OddOrEven oddOrEven(int number) {
    if (number %2 == 0) {
      return OddOrEven.EVEN;
    } else {
      return OddOrEven.ODD;
    }
  }

  static enum OddOrEven {
    ODD,
    EVEN;
  }
}
