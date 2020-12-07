package year2020.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner("dummyScannerObject");
        try {
            scanner = new Scanner(new File("resources/input06.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        HashSet<Character> answers = new HashSet<>();
        int result = 0;
        while (scanner.hasNextLine()) {
            boolean firstLine = true;
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    result+=answers.size();
                    break;
                } else {
                    HashSet<Character> lineAnswers = new HashSet<>();
                    for (int i = 0; i < line.length(); i++) {
                        lineAnswers.add(line.charAt(i));
                    }
                    if (firstLine) {
                        answers = lineAnswers;
                        firstLine = false;
                    } else {
                        answers.retainAll(lineAnswers);
                    }
                }
            }
        }
        result+= answers.size();
        System.out.println(result);
    }
}
