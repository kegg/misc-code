import java.util.List;
import java.util.ArrayList;

public class Collatz {

  public static void main(String[] args) {
    int i = Integer.valueOf(args[0]);
    int attempts = 0;

	List<Integer> numbers = new ArrayList<>();
	numbers.add(i);

    while (i != 1) {
      OddOrEven oddOrEven = oddOrEven(i);

      if (oddOrEven == OddOrEven.EVEN) {
        i = i / 2;
      } else if (oddOrEven == OddOrEven.ODD) {
        i = (i * 3) + 1;
      }

      numbers.add(i);

      attempts++;
    }
	
	int k = 0;
	
	for (int j = 0; j < numbers.size(); j++) {
		if (k == 10) {
			k = 0;
			System.out.printf("%n");
		}
		k++;
		System.out.printf("%5d", numbers.get(j));
	}
	
    System.out.printf("%nThis attempt took %d tries%n", attempts);
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
