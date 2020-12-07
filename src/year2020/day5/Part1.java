package year2020.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner("dummyScannerObject");
        try {
            scanner = new Scanner(new File("resources/input05.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        int result = 0;
        while (scanner.hasNextLine()) {
            BoardingPass pass = new BoardingPass(scanner.nextLine());
            if (pass.getSeatID()> result) {
                result = pass.getSeatID();
            }
        }
        System.out.println(result);
    }
}
