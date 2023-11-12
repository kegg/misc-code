import java.util.Map;
import java.util.TreeMap;

public class SoMain {
    Map<String, Person> nameToPersonMap = 
            new TreeMap<String, Person>(String.CASE_INSENSITIVE_ORDER);

    public static void main(String[] args) {
        new SoMain().run(args);
    }

    private void run(String[] args) {
        addPerson(new Person("Jim McDonald", 1));
        addPerson(new Person("Jim Mcdonald", 2));
        addPerson(new Person("John Smith", 3));

        System.out.println("Number of people: " 
                    + nameToPersonMap.entrySet().size());
        System.out.println("Jim McDonald id: " 
                    + getPerson("Jim McDonald").getPersonId());
        System.out.println("John Smith id: " 
                    + getPerson("john smith").getPersonId());
    }

    private void addPerson(Person p) {
        nameToPersonMap.put(p.getName(), p);
    }

    private Person getPerson(String name) {
        return nameToPersonMap.get(name);
    }

    public static class Person {
        private String name;
        private int personId;

        public Person(String name, int personId) {
            this.name = name;
            this.personId = personId;
        }

        public int getPersonId() {
            return personId;
        }

        public String getName() {
            return name;
        }
    }
}
