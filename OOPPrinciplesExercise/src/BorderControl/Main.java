package BorderControl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Citizen> citizens = new ArrayList<>();
        List<Robot> robots = new ArrayList<>();

        while(true){
            String[] inputArgs = scanner.nextLine().split("\\s+");

            if(inputArgs[0].equals("End")){
                break;
            }

            if(inputArgs.length == 3) {
                Citizen citizen = new Citizen(inputArgs[0], Integer.parseInt(inputArgs[1]), inputArgs[2]);
                citizens.add(citizen);
            }
            else{
                Robot robot = new Robot(inputArgs[0], inputArgs[1]);
                robots.add(robot);
            }

        }

        String ending = scanner.nextLine();

        for(int i = 0; i < citizens.size(); i++){
            if(citizens.get(i).getId().endsWith(ending)){
                System.out.println(citizens.get(i).getId());
            }
        }

        for(int i = 0; i < robots.size(); i++){
            if(robots.get(i).getId().endsWith(ending)){
                System.out.println(robots.get(i).getId());
            }
        }

    }
}
