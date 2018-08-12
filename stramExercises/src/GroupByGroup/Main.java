package GroupByGroup;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        while(true){
            String[] inputArgs = scanner.nextLine().split("\\s+");
            if(inputArgs[0].equals("END")){
                break;
            }

            String firstname = inputArgs[0];
            String lastname = inputArgs[1];
            int group = Integer.parseInt(inputArgs[2]);

            Person person = new Person(firstname, lastname, group);
            people.add(person);
        }

        people.stream()
                .collect(Collectors.groupingBy(Person::getGroup))
                .entrySet().stream().forEach(p-> System.out.println(p.getKey()));

    }
}
