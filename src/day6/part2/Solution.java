package day6.part2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Scanner;

public class Solution {
    static Scanner scanner;

    public static void main(String[] args) {
        //input and output
        scanner = new Scanner(Solution.class.getResourceAsStream("../input6.txt"));
        HashMap<String, Planet> planets = new HashMap<>();

        //read next line
        while(scanner.hasNext()) {
            String[] connection = scanner.nextLine().split("\\)");
            //if planets not in hashmap, add them
            for (String orbit: connection) {
                if (!planets.containsKey(orbit)) {
                    planets.put(orbit, new Planet(orbit));
                } }
            //add first planet as the object 2nd planet orbits around
            planets.get(connection[1]).orbit = Optional.of(planets.get(connection[0]));
        }

        //generate routes for start and end point to the core
        LinkedList<Planet> routeYou = getRoute(planets.get("YOU"));
        LinkedList<Planet> routeSem = getRoute(planets.get("SAN"));

        //while both routes have the same planet, move forward
        while(routeYou.getLast().equals(routeSem.getLast())) {
            routeYou.pollLast();
            routeSem.pollLast();
            if (routeYou.isEmpty()||routeSem.isEmpty()) {
                //if one of the planets lies directly on route to core of the other planet
                System.out.println((routeSem.size()+routeYou.size()));
                return;
            }
        }
        //if the route forks at some point
        System.out.println((routeYou.size()+routeSem.size()));
    }

    private static LinkedList<Planet> getRoute(Planet planet) {
        LinkedList<Planet> result = new LinkedList<>();
        //while planet orbits something, add the object to list and go there
        while(planet.orbit.isPresent()) {
            result.add(planet.orbit.get());
            planet = planet.orbit.get();
        }
        return result;
    }
}
