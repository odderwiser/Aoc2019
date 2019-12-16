package day10;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

/**
 * Represesnts an asteroid
 */
public class Asteroid {
    Coords coords;
    HashSet<Asteroid> invisible;
    Map mother;

    /**
     * Make new asteroid.
     * @param x - x coordinate.
     * @param y - y cooradinate.
     * @param mother - map that created the asteroid.
     */
    public Asteroid(int x, int y, Map mother) {
        coords = new Coords(x, y);
        invisible = new HashSet<>(Collections.singletonList(this));
        this.mother = mother;
    }

    /**
     * Add given asteroid to the invisible list.
     * If other asteroid is invisible for this asteroid,
     *     this asteroid is also invisible for other asteroid.
     * @param other - other Asteroid.
     */
    public void makeInvisible(Asteroid other) {
        this.invisible.add(other);
        other.invisible.add(this);
    }

    /**
     * Check what asteroids does asteroid other cover from this
     *     asteroid's point of view. If such asteroid exists, mark it as invisible.
     * @param other - other asteroid, implicitly visible.
     */
    public void checkCovering(Asteroid other) {
        Coords that = new Coords(other.coords.x, other.coords.y);
        //get the smallest direction vector from this to other
        Direction between = this.coords.getDirection(that);
        that.add(between);

        //while new coordinates are still on map:
        while(mother.inRange(that)) {
            //check if there is an asteroid with given coords, if yes, make invisible.
            Optional<Asteroid> check= mother.get(that);
            if (check.isPresent()) {
                other = check.get();
                makeInvisible(other);
            }
            that.add(between);
        }
    }

    /**
     * get the smallest direction vector
     *      from this asteroid to asteroid other.
     * @param other - other asteroid to which we want to find direction.
     * @return - Relative coordinates of direction - vector pointing from this to other.
     */
    public Direction getDirection(Asteroid other) {
        Direction result = this.coords.getDirection(other.coords);
        return result;
    }

}
