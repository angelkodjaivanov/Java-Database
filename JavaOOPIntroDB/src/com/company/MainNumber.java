package com.company;
import java.util.*;
public class MainNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Number number = new Number();
        number.number = scanner.nextInt();

        int result = number.func();
        System.out.println(result);
    }
}
