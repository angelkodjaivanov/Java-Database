package com.company;
import java.util.*;
import java.util.stream.Stream;

public class StrudentsByGroupMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while(true){
            String[] inputArgs = scanner.nextLine().split(" ");

            if(inputArgs[0].equals("END")){
                break;
            }

            Student student = new Student(inputArgs[0], inputArgs[1], Integer.parseInt(inputArgs[2]));

            students.add(student);
        }

        students.stream().filter(p -> p.getGroupNumber() == 2).sorted(Comparator.comparing(Student::getFirstname)).
                forEach(p -> System.out.println(p.getFirstname() + " " + p.getSecondName()));

    }
}

