package com.company;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class StudentsByFirstAndLastName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Studenter> studenters = new ArrayList<>();

        while (true){
            String[] inputArgs = scanner.nextLine().split("\\s+");
            if(inputArgs[0].equals("END")){
                break;
            }

            String firstname = inputArgs[0];
            String lastname = inputArgs[1];

            Studenter studenter = new Studenter(firstname, lastname);
            studenters.add(studenter);
        }

        studenters.stream()
                .sorted(Comparator.comparing(Studenter::getLastname).thenComparing(Studenter::getFirstname).reversed())
                .forEach(p -> System.out.println(p.getFirstname() + " " + p.getLastname()));

    }
}

class Studenter{
    private String firstname;

    private String lastname;

    public Studenter(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
