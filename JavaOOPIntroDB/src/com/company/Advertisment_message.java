package com.company;
import java.util.*;

public class Advertisment_message {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int messages = Integer.parseInt(scanner.nextLine());

        String[] phrases = new String[]{"Excellent product.", "Such a great product.", "I always use that product.",
                "Best product of its  category.", "Exceptional product.", "I can’t live without this product"};
        String[] events = new String[]{"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.", "Try it yourself", "I am very satisfied.", "I feel great!"};
        String[] authors = new String[]{"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] towns = new String[]{"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};
        for(int i = 0; i < messages; i++){
            Random rnd = new Random();
            int phrasesIndex =  rnd.nextInt(phrases.length);
            int eventsIndex =  rnd.nextInt(events.length);
            int authorsIndex =  rnd.nextInt(authors.length);
            int townsIndex =  rnd.nextInt(towns.length);

            System.out.println(phrases[phrasesIndex] + " " + events[eventsIndex] + " " + authors[authorsIndex]
                + " - " + towns[townsIndex]);
        }

    }
}
