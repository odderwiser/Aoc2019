package year2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Util {

    public static Scanner parseInput(String filename) {
        Scanner scanner = new Scanner("dummyScannerObject");
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return scanner;
    }
}
