package year2020.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner("dummyScannerObject");
        try {
            scanner = new Scanner(new File("resources/input03.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        Map map = new Map(scanner);
        System.out.println(map.jumpThrough(3, 1));
    }
}