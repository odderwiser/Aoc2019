package Day3.PartTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    static Scanner scanner;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("C:\\Users\\owolska\\Documents\\Google\\AdventOfCode2019\\src\\Day3\\input3.txt");
        scanner = new Scanner(file);
        HashSet<Coordinates> firstWire = makeSet(scanner.nextLine());
        HashSet<Coordinates> secondWire = makeSet(scanner.nextLine());

        firstWire.retainAll(secondWire);
        secondWire.retainAll(firstWire);

        int result = Integer.MAX_VALUE;
        for(Coordinates coords: firstWire) {
            int distance = coords.stepnum;
            for (Coordinates coord: secondWire) {
                if (coords.equals(coord)) {
                    distance+=coord.stepnum;
                    break;
                }
            }
            if (distance < result) {
                result = distance;
            }
        }
        System.out.println("The result is: "+result);
    }

    private static HashSet<Coordinates> makeSet(String line) {
        String[] strings = line.split(",");
        HashSet<Coordinates> result = new HashSet<>();
        Coordinates coords = new Coordinates(0, 0, 0);
        int stepnum = 0;
        for (String string: strings) {
            Directions directions = new Directions(string, stepnum);
            stepnum = stepnum+directions.distance;
            result.addAll(directions.makeMove(coords));
            coords = directions.newCoords(coords);
        }
        return result;
    }

}

