package BirthdayCelebrations;
import com.company.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Citizen> citizens = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();
        List<Robot> robots = new ArrayList<>();

        while(true){
            String[] inputArgs = scanner.nextLine().split("\\s+");

            if(inputArgs[0].equals("End")){
                break;
            }

            switch (inputArgs[0]){
                case "Citizen":
                    Citizen citizen = new Citizen(inputArgs[1], Integer.parseInt(inputArgs[2]), inputArgs[3], inputArgs[4]);
                    citizens.add(citizen);
                    break;
                case "Pet":
                    Pet pet = new Pet(inputArgs[1], inputArgs[2]);
                    pets.add(pet);
                    break;
                case "Robot":
                    Robot robot = new Robot(inputArgs[1], inputArgs[2]);
                    robots.add(robot);
                    break;
            }

        }

        String year = scanner.nextLine();

        for(int i = 0; i < citizens.size(); i++){
            if(citizens.get(i).isInTheYear(year)){
                System.out.println(citizens.get(i).getDate());
            }
        }

        for(int i = 0; i < pets.size(); i++){
            if(pets.get(i).isInTheYear(year)){
                System.out.println(pets.get(i).getDate());
            }
        }

    }
}
