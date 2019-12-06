package day6.part1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(Solution.class.getResourceAsStream("../input6.txt"));
        HashMap<String, Planet> planets = new HashMap<>();
        while(scanner.hasNext()) {
            String[] connection = scanner.nextLine().split("\\)");
            for (String orbit: connection) {
                if (!planets.containsKey(orbit)) {
                    planets.put(orbit, new Planet());
                }
            }
            planets.get(connection[0]).add(planets.get(connection[1]));
        }
        int result = solve(planets);
        System.out.println(result);
    }

    private static int solve(HashMap<String, Planet> planets) {
        int result = 0;
        LinkedList<Planet> iterate = new LinkedList<>();
        iterate.add(planets.get("COM"));
        while(iterate.size()>0) {
            Planet planet = iterate.poll();
            int counter = planet.counter;
            result+=counter;
            counter++;
            for (Planet object: planet.orbits) {
                object.setCounter(counter);
                iterate.add(object);
            }
        }

        return result;
    }

    //każda orbita po
}
