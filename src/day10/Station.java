package day10;

import java.util.*;

public class Station {
    Asteroid station;
    Map mother;
    HashMap<Coords, LinkedList<Asteroid>> shooting;

    public Station(Map map, Asteroid station) {
        this.mother = map;
        this.station = station;
        shooting = new HashMap<>();
        assignAsteroids();
    }

    private void assignAsteroids() {
        for(Asteroid asteroid : mother.asteroids()) {
            asteroid.setDistance(station);

            if (!station.invisible.contains(asteroid)) {
                //get the direction from the station
                Coords direction = station.getDirection(asteroid);

                //add new coordinates to the hashmap
                LinkedList<Asteroid> asteroids = new LinkedList<>();
                shooting.put(direction, asteroids);
                asteroids.add(asteroid);

                //make coords for traversing the map
                Coords that = new Coords(asteroid.coords.x, asteroid.coords.y);
                that.add(direction);

                //traverse the map searching for asteroids
                while(mother.inRange(that)) {
                    Optional<Asteroid> ast = mother.get(that);
                    ast.ifPresent(asteroids::add);
                    that.add(direction);
                }
            }
        }
    }

    public ArrayList<Coords> getKeySet() {
        ArrayList<Coords> keys = new ArrayList<>(shooting.keySet());
        Collections.sort(keys);
        for (int i = 0; i < keys.size(); i++) {
            System.out.print(keys.get(i)+", ");
        }
        return keys;
    }

    public Coords destroy(Coords key) {
        LinkedList<Asteroid> check = this.shooting.get(key);
        Coords result = check.removeFirst().coords;
        if (check.size()==0) {
            this.shooting.remove(key);
        }
        System.out.println("Deleted coords "+result.toString());
        return result;
    }
}
