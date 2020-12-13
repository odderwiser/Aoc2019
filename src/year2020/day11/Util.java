package year2020.day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Util {

    public static Ferry parseInput(String filename, Ferry ferry) {
        Scanner scanner = new Scanner("dummyScannerObject");
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        while (scanner.hasNextLine()) {
            ferry.addRow(scanner.nextLine());
        }
        return ferry;
    }

    static int solve(Ferry ferry) {
        String oldValue = ferry.stringValue();
        ferry.addingRound();
        String newValue = ferry.stringValue();
        while (!oldValue.equals(newValue)) {
            ferry.removingRound();
            ferry.addingRound();
            oldValue = newValue;
            newValue = ferry.stringValue();

        }
        return ferry.countSeats();
    }
}
