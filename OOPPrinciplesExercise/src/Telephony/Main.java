package Telephony;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numberArgs = scanner.nextLine().split("\\s+");
        String[] urlArgs = scanner.nextLine().split("\\s+");

        Smartphone smartphone = new Smartphone();
        for(int i = 0; i < numberArgs.length;i++){
            System.out.println(smartphone.calling(numberArgs[i]));
        }

        for(int i = 0; i < urlArgs.length;i++){
            System.out.println(smartphone.browsing(urlArgs[i]));
        }

    }
}
