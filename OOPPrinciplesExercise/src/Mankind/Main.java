package Mankind;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] studentArgs = scanner.nextLine().split("\\s+");
        String[] workerArgs = scanner.nextLine().split("\\s+");

        Student student = new Student(studentArgs[0], studentArgs[1], studentArgs[2]);
        Worker worker = new Worker(workerArgs[0], workerArgs[1], Double.parseDouble(workerArgs[2]), Integer.parseInt(workerArgs[3]));

        if(student.correctName() != null){
            System.out.println(student.correctName());
        }
        else if(student.correctFacultyNumber() != null){
            System.out.println(student.correctFacultyNumber());
        }
        else{
            System.out.println("First Name: " + student.getFirstName());
            System.out.println("Last Name: " + student.getLastName());
            System.out.println("Faculty Number: " + student.getFacultyNumber());
        }

        System.out.println();

        if(worker.correctName() != null){
            System.out.println(worker.correctName());
        }
        else if(worker.correctWorkerProp() != null){
            System.out.println(worker.correctWorkerProp());
        }
        else{
            System.out.println("First Name: " + worker.getFirstName());
            System.out.println("Last Name: " + worker.getLastName());
            System.out.println("Week Salary: " + worker.getWeekSalary());
            System.out.println("Hours per Day: " + worker.getWorkHoursPerDay());
        }

    }
}
