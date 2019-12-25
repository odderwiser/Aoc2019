package day10;


import java.util.*;

/**
 * Represents the map as given by input.
 */
public class Map {
    HashMap<Point,  Asteroid> asteroids;
    int sizeX;
    int sizeY;

    /**
     * Make map
     */
    public Map() {
        asteroids = new HashMap<>();
        sizeX = 0;
        sizeY = 0;
    }

    /**
     * Add asteroid to the map
     * @param ast - asteroid to be added.
     */
    public void add(Asteroid ast) {
        sizeX = Math.max(sizeX, ast.point.x + 1);
        sizeY = Math.max(sizeY, ast.point.y + 1);
        asteroids.put(ast.point, ast);
    }

    /**
     * Check if given coordinates are in range of a map,
     *  between (0, sizeX) on x axis
     *  and between (0, sizeY) on y axis
     * @param point - coordinates to be checked
     * @return - true if coordinates lie in map boundaries
     */
    public boolean inRange(Point point) {
        return point.x < sizeX && point.x >= 0 &&
                point.y < sizeY && point.y >= 0;
    }

    /**
     * Returns an asteroid or lack of it, given coordinates to be checked
     * @param point - coordinates to be checked
     * @return - Optional of Asteroid if it exists, else an empty Optional.
     */
    public Optional<Asteroid> get(Point point) {
        return Optional.ofNullable(this.asteroids.get(point));
    }

    /**
     * Checks for given asteroid, what asteroids does every asteroid cover.
     * Permanently marks invisible asteroids
     * @param asteroid - asteroid to be compared
     */
    public void setAsteroidInvisibles(Asteroid asteroid) {
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
    public Asteroid getAndRemoveStation() {
        Asteroid result = asteroids().stream()
                .min(Comparator.comparingInt(as -> as.invisible.size())).get();
        this.asteroids.remove(result.point);
        return result;
    }
}
