package org.example;

// Fig. 17.12: ArraysAndStreams2.java
// Demonstrating lambdas and streams with an array of Strings.
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ArraysAndStreams2 {
    public static void main(String[] args) {
        String[] strings =
                {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};

        // display original strings
        System.out.printf("Original strings: %s%n", Arrays.asList(strings));

        // strings in uppercase
        System.out.printf("strings in uppercase: %s%n",
                Arrays.stream(strings)
                        .map(String::toUpperCase)
                        .collect(Collectors.toList()));

        // strings less than "n" (case insensitive) sorted ascending
        System.out.printf("strings less than n sorted ascending: %s%n",
                Arrays.stream(strings)
                        .filter(s -> s.compareToIgnoreCase("n") < 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER)
                        .collect(Collectors.toList()));

        // strings less than "n" (case insensitive) sorted descending
        System.out.printf("strings less than n sorted descending: %s%n",
                Arrays.stream(strings)
                        .filter(s -> s.compareToIgnoreCase("n") < 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                        .collect(Collectors.toList()));

        //NEW LAB WORK BELOW:
        Predicate<String> startsWithVowel = s -> { //Define a predicate for 1 (Boolean)
            char first = Character.toLowerCase(s.charAt(0)); //all to lowercase (For any size)
            return first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u' || first == 'y'; //return if first == vowel
        };
        Predicate<String> lettercount = s -> { //Define a predicate for 1 (Boolean)
            int i = s.length();
            return i>5;
        };

        System.out.printf("Use a stream to filter strings that start with a vowel (case-insensitive): %s%n",
                Arrays.stream(strings)
                        .filter(startsWithVowel)
                        .collect(Collectors.toList()));

        System.out.printf("Use a stream to concatenate all the strings into a single string, separated by a comma: %s%n",
                String.join(", ", strings));

        System.out.printf("Use a stream to count the number of strings that contain more than 5 characters (case-insensitive) and display the count: %s%n",
                Arrays.stream(strings)
                        .filter(lettercount)
                        .collect(Collectors.toList()));
    }

}
