import java.util.Vector;

public class Fib {
    public static void main(String[] args) {
        int i = 0, j = 1;

        Vector<Integer> vec = new Vector<>();
        vec.add(i);
        vec.add(j);

        System.out.println(vec.firstElement());

        do {
            System.out.println(vec.lastElement());
            vec.add(i+j);
            i = j;
            j = (int)vec.lastElement();
        } while ((int)vec.lastElement() < 25);
    }
}
