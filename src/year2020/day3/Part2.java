package year2020.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner("dummyScannerObject");
        try {
            scanner = new Scanner(new File("resources/input03.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        Map map = new Map(scanner);
        int[] horizontal = {1,3,5,7,1};
        int[] vertical = {1,1,1,1,2};
        int result = 1;
        for (int i = 0; i< horizontal.length; i++) {
            result = result*(map.jumpThrough(horizontal[i], vertical[i]));
        }
        System.out.println(result);
    }
}