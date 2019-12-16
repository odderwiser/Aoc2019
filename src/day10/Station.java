package day10;

import java.util.*;

/**
 * Represents a view on the map from a given asteroid on all other asteroids.
 */
public class Station {
    Asteroid station;
    Map mother;
    HashMap<Direction, LinkedList<Asteroid>> shooting;

    /**
     * Create the object
     * @param map - map as the basis of the view.
     * @param station - point of view on the map.
     */
    public Station(Map map, Asteroid station) {
        this.mother = map;
        this.station = station;
        shooting = new HashMap<>();
        assignAsteroids();
    }

    /**
     * Helper method for creating the station.
     * Assigns all asteroids from the map to a certain line of view (vector from the station Asteroid).
     */
    private void assignAsteroids() {
        for(Asteroid asteroid : mother.asteroids()) {
            //for every asteroid set distance to the station

            //envoke only if asteroid is the first in line of view of the central asteroid.
            if (!station.invisible.contains(asteroid)) {
                //get the direction from the station
                Direction direction = station.getDirection(asteroid);

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

    /**
     * Get the set of directions from the central station that contains asteroids
     * @return - ArrayList of sorted directions from smallest angle clockwise.
     */
    public ArrayList<Direction> getKeySet() {
        //make arraylist from the keys of hasmpap and sort it
        ArrayList<Direction> keys = new ArrayList<>(shooting.keySet());
        Collections.sort(keys);

        //validating the sorting
        for (int i = 0; i < keys.size(); i++) {
            System.out.println("x: "+keys.get(i).x+" y: "+keys.get(i).y+" distance: "
                    +keys.get(i).distance+" rotation: "+keys.get(i).getRotation());
            for (Asteroid ast: shooting.get(keys.get(i))) {
                System.out.print(ast.coords.toString()+", ");
            }
            System.out.print("\n");
        }
        return keys;
    }

    /**
     * Remove first visible asteroid in given direction
     * @param key - direction to be checked
     * @return - coordinates of the destroyed aasteroid
     */
    public Coords destroy(Coords key) {
        //get list of asteroids, sorted from closest to furthest.
        LinkedList<Asteroid> check = this.shooting.get(key);
        //remove first asteroid and retrieve it's coordinates/
        Coords result = check.removeFirst().coords;
        //if there are no more asteroids in given direction, remove the direction.
        if (check.size()==0) {
            this.shooting.remove(key);
        }
        //validation
        System.out.println("Deleted coords "+result.toString());
        return result;
    }
}
