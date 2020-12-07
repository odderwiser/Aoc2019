package year2020.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner("dummyScannerObject");
        try {
            scanner = new Scanner(new File("resources/input05.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        HashSet<Integer> usedSeats = new HashSet<>();
        while (scanner.hasNextLine()) {
            BoardingPass pass = new BoardingPass(scanner.nextLine());
            usedSeats.add(pass.getSeatID());
        }
        for (Integer value: usedSeats) {
            if(!usedSeats.contains(value+1) && (usedSeats.contains(value+2))) {
               System.out.println(value+1);
               break;
            }
            if(!usedSeats.contains(value-1) && (usedSeats.contains(value-2))) {
                System.out.println(value-1);
                break;
            }
        }
    }

}