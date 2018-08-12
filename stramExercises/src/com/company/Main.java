package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();

        integers.add(1);
        integers.add(22);
        integers.add(23);
        integers.add(3);
        integers.add(101);
        integers.add(8);

        integers.stream().filter(p -> p < 100 && p > 4).sorted().mapToInt(p -> p * 10).forEach(p -> System.out.println(p));
        System.out.println(integers.stream().anyMatch(p -> p % 8 == 0));
    }
}
