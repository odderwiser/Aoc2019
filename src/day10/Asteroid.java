package day10;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

public class Asteroid {
    Coords coords;
    HashSet<Asteroid> invisible;
    Map mother;

    public Asteroid(int x, int y, Map mother) {
        coords = new Coords(x, y);
        invisible = new HashSet<>(Collections.singletonList(this));
        this.mother = mother;
    }

    public void makeInvisible(Asteroid other) {
        this.invisible.add(other);
        other.invisible.add(this);
    }

    public void checkCovering(Asteroid other) {
        Coords that = new Coords(other.coords.x, other.coords.y);
        Coords between = this.coords.getGcd(that);
        that.add(between);

        while(mother.inRange(that)) {
            Optional<Asteroid> check= mother.get(that);
            if (check.isPresent()) {
                other = check.get();
                makeInvisible(other);
            }
            that.add(between);
        }
    }

    public void setDistance(Asteroid station) {
        this.coords.setDistance(station.coords);
    }

    public Coords getDirection(Asteroid other) {
        Coords result = this.coords.getGcd(other.coords);
        result.setDistance(other.coords);
        return result;
    }

}
