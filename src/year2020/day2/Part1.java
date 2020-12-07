package year2020.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner("dummyScannerObject");
        try {
            scanner = new Scanner(new File("resources/input02.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        int result = 0;
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            String[] boundaries = line[0].split("-");
            int lowerBound = Integer.parseInt(boundaries[0]);
            int upperBound = Integer.parseInt(boundaries[1]);
            char c = line[1].charAt(0);
            int counter = 0;
            for (int i = 0; i < line[2].length(); i++) {
                if (line[2].charAt(i)==c) {
                    counter++;
                }
            }
            if (counter >= lowerBound && counter <= upperBound) {
                result++;
            }
        }
        System.out.println(result);
    }
}