package day10;


import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

public class Map {
    HashMap<Coords,  Asteroid> asteroids;
    int xSize;
    int ySize;

    public Map() {
        asteroids = new HashMap<>();
        xSize = 0;
        ySize = 0;
    }

    public void add(Asteroid ast) {
        asteroids.put(ast.coords, ast);
    }

    public boolean inRange(Coords coords) {
        return (coords.x < xSize && (coords.x >= 0 &&
                (coords.y < ySize && (coords.y >= 0))));
    }

    public Optional<Asteroid> get(Coords coords) {
        return Optional.ofNullable(this.asteroids.get(coords));
    }

    public void checkAsteroid(Asteroid asteroid) {
        HashSet<Asteroid> neighbours = asteroid.invisible;

        for (Asteroid ast: this.asteroids()) {
            if (!neighbours.contains(ast)) {
                asteroid.checkCovering(ast);
            }
        }
    }

    public Collection<Asteroid> asteroids() {
        return this.asteroids.values();
    }

    public Asteroid setStation() {

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
