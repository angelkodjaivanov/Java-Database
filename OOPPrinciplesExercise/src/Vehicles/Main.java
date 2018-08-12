package Vehicles;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       String[] carArgs = scanner.nextLine().split("\\s+");
       String[] truckArgs = scanner.nextLine().split("\\s+");

       Car car = new Car(Double.parseDouble(carArgs[1]), Double.parseDouble(carArgs[2]));
       Truck truck = new Truck(Double.parseDouble(truckArgs[1]), Double.parseDouble(truckArgs[2]));

       int n = Integer.parseInt(scanner.nextLine());

       for(int i = 0; i < n; i++){
           String[] commandArgs = scanner.nextLine().split("\\s+");

           if(commandArgs[1].equals("Car")){
               if(commandArgs[0].equals("Drive")){
                   car.drive(Double.parseDouble(commandArgs[2]));
               }
               else if(commandArgs[0].equals("Refuel")){
                   car.refuel(Double.parseDouble(commandArgs[2]));
               }
           }

           if(commandArgs[1].equals("Truck")){
               if(commandArgs[0].equals("Drive")){
                   truck.drive(Double.parseDouble(commandArgs[2]));
               }
               else if(commandArgs[0].equals("Refuel")){
                   truck.refuel(Double.parseDouble(commandArgs[2]));
               }
           }
       }

        System.out.println(car.getFuelQuantity());
        System.out.println(truck.getFuelQuantity());
    }
}
