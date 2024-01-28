public class Hello2024 {
    public static void main(String[] args) {
        if (System.console() == null) {
            System.out.println("Hello 2024! (from the IDE)");
        } else {
            System.console().printf("%s","Hello 2024!");
        }
    }
}