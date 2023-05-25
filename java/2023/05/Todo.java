import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Todo {

    private final List<String> todoItems;
    private final Console console;

    public Todo() {
        console = System.console();
        todoItems = new ArrayList<>();
    }

    public static void main(String[] args) {
        Todo todo = new Todo();
        todo.process();
    }

    private void process() {
        String input;
        do {
            menu();
            input = console.readLine("%s> ", "todo");

            if (!input.matches("[0-3]")) {
                print("Invalid Menu Option%n");
            } else {
                process(input);
            }
        } while (!input.equals("0"));
    }

    private void process(String input) {
        int choice = Integer.parseInt(input);
        switch (choice) {
            case 1:
                add();
                break;
            case 2:
                remove();
                break;
            case 3:
                display();
                break;
        }
    }

    private void add() {
        String input = console.readLine("%s%n> ", "TODO Text");
        todoItems.add(input);
    }

    private void remove() {
        String input = console.readLine("%s%n> ", "Todo Item To Remove");
        String regex = String.format("[%d-%d]", 0, todoItems.size()) ;
        if (input.matches(regex)) {
            int id = Integer.parseInt(input);
            todoItems.remove(id - 1);
        }
    }

    private void display() {
        print("------------%n");
        print("Todo Items%n");
        print("------------%n");
        for (int i = 0; i < todoItems.size(); i++) {
            print("%d. %s%n", i+1, todoItems.get(i));
        }
        print("------------%n");
    }

    private void menu() {
        print("1. Add ToDo Item%n");
        print("2. Remove ToDo Item%n");
        print("3. Print ToDo List%n");
        print("0. Exit%n");
    }

    private void print(String format, Object...args) {
        System.out.printf(format, args);
    }
}
