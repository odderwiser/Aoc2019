package day3.part_one;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(Solution.class.getResourceAsStream("../input3.txt"));
        HashSet<Coordinates> firstWire = makeSet(scanner.nextLine());
        HashSet<Coordinates> secondWire = makeSet(scanner.nextLine());

        firstWire.retainAll(secondWire);

        int result = firstWire.stream().min(Comparator.comparingInt(Coordinates::manhattanDistance))
                .get().manhattanDistance();
        System.out.println("The result is: "+result);
    }

    private static HashSet<Coordinates> makeSet(String line) {
        String[] strings = line.split(",");
        HashSet<Coordinates> result = new HashSet<>();
        Coordinates coords = new Coordinates(0, 0);
        for (String string: strings) {
            Directions directions = new Directions(string);
            result.addAll(directions.makeMove(coords));
            coords = directions.newCoords(coords);
        }
        return result;
    }

}

