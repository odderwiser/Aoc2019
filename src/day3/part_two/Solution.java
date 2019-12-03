package day3.part_two;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(Solution.class.getResourceAsStream("../input3.txt"));
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

