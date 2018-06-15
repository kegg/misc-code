import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TestEach {

  public static void main(String[] args) {
    List<String> names = Arrays.asList("Larry", "Steve", "James");
  
    Consumer<String> consumerNames = name -> {
      System.out.println(name);
    };
    
    // names.forEach(consumerNames);
    
    // names.forEach(name -> System.out.println(name));
    
    names.forEach(System.out::println);
  }

}