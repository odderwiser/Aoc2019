package year2020.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {
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
            int lowerBound = Integer.parseInt(boundaries[0])-1;
            int upperBound = Integer.parseInt(boundaries[1])-1;
            char c = line[1].charAt(0);
            int counter = 0;
            if (upperBound >=line[2].length() || lowerBound>= line[2].length()){
                continue;
            }
            if (line[2].charAt(lowerBound)== c ^ line[2].charAt(upperBound)==c) {
                result++;
            }
        }
        System.out.println(result);
    }
}
