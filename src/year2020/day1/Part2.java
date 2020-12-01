package year2020.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Part2 {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner("dummyScannerObject");
        try  {
            scanner = new Scanner(new File("resources/input01.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        HashSet<Integer> numbers = new HashSet<>();
        HashMap<Integer, Integer> summedNumbers = new HashMap<>();//summed numbers, multiplied numbers.
        int i = 0;
        while (scanner.hasNextInt()) {
            int next = scanner.nextInt();
            for (Integer integ: numbers) {
                summedNumbers.put(next+integ, next*integ);
            }
            numbers.add(next);
        }
        for (Integer integ: summedNumbers.keySet()) {
            if (numbers.contains(2020-integ)) {
                System.out.println((summedNumbers.get(integ)*(2020-integ)));
                break;
            }
        }
    }
}