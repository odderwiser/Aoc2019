package year2020.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part1 {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner("dummyScannerObject");
        try  {
        scanner = new Scanner(new File("resources/input01.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        ArrayList<Integer> numbers = new ArrayList<>();
        int i = 0;
        while (scanner.hasNextInt()) {
            int next = scanner.nextInt();
            for (int j = 0; j< i; j++) {
                if (numbers.get(j) + next == 2020) {
                    System.out.println((numbers.get(j) * next));
                    return;
                }
            }
            numbers.add(next);
            i++;
        }
    }
}
