package day10;


import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

/**
 * Represents the map as given by input.
 */
public class Map {
    HashMap<Coords,  Asteroid> asteroids;
    int xSize;
    int ySize;

    /**
     * Make map
     */
    public Map() {
        asteroids = new HashMap<>();
        xSize = 0;
        ySize = 0;
    }

    /**
     * Add asteroid to the map
     * @param ast - asteroid to be added.
     */
    public void add(Asteroid ast) {
        asteroids.put(ast.coords, ast);
    }

    /**
     * Check if given coordinates are in range of a map,
     *  between (0, xSize) on x axis
     *  and between (0, ySize) on y axis
     * @param coords - coordinates to be checked
     * @return - true if coordinates lie in map boundaries
     */
    public boolean inRange(Coords coords) {
        return (coords.x < xSize && (coords.x >= 0 &&
                (coords.y < ySize && (coords.y >= 0))));
    }

    /**
     * Returns an asteroid or lack of it, given coordinates to be checked
     * @param coords - coordinates to be checked
     * @return - Optional of Asteroid if it exists, else an empty Optional.
     */
    public Optional<Asteroid> get(Coords coords) {
        return Optional.ofNullable(this.asteroids.get(coords));
    }

    /**
     * Checks for given asteroid, what asteroids does every asteroid cover.
     * Permanently marks invisible asteroids
     * @param asteroid - asteroid to be comapred
     */
    public void checkAsteroid(Asteroid asteroid) {
        HashSet<Asteroid> neighbours = asteroid.invisible;

        for (Asteroid ast: this.asteroids()) {
            //if asteroid isn't already invisible, check which asteroids it covers
            if (!neighbours.contains(ast)) {
                asteroid.checkCovering(ast);
            }
        }
    }

    /**
     * Get a Collection containing all observed asteroids.
     * @return - collection of all observed asteroids.
     */
    public Collection<Asteroid> asteroids() {
        return this.asteroids.values();
    }

    /**
     * Get asteroid that has the most asteroids visible.
     * @return - Asteroid as described.
     */
    public Asteroid getStation() {

        Asteroid result = new Asteroid(0, 0, this);
        int invisible = Integer.MAX_VALUE;
        for (Asteroid asteroid : asteroids()) {
            if (asteroid.invisible.size() < invisible) {
                result = asteroid;
                invisible = asteroid.invisible.size();
            }
        }
        this.asteroids.remove(result.coords);
        return result;
    }
}
