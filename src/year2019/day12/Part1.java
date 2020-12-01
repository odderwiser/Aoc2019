package year2019.day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) {
        Map map = new Map();
        try {
            Scanner scanner = new Scanner(new File("resources/input12.txt"));
            while(scanner.hasNextLine()) {
                map.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 1000; i++) {
            map.applyGravity();
            map.applyVelocity();
        }
        System.out.println(map.getEnergy());
    }
}
