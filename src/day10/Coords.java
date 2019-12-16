package day10;

import java.util.Objects;

/**
 * Represents two dimentional directions and distance two some center coordinates
 */
public class Coords {
    int x;
    int y;

    /**
     * Initialise coordinates
     * @param x - x coordinate
     * @param y - y coordinate
     */
    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Check if this equals other object, based on x and y coordinates.
     * @param o - Object other.
     * @return - true if objects are equal, else false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coords coords = (Coords) o;
        return x == coords.x &&
                y == coords.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Get the smallest integer distance vector from here to coords other.
     * @param other - other asteroid to which the vector is pointing
     * @return - Coords of vector from here to other.
     */
    public Direction getDirection(Coords other) {
        Direction result = new Direction(other.x - this.x, other.y - this.y);

        //if they're on the same line
        if (result.x == 0) {
            return new Direction(0, Integer.signum(result.y));
        }
        if (result.y == 0) {
            return new Direction(Integer.signum(result.x), 0);
        }

        int gcd = getGCD(Math.abs(result.x), Math.abs(result.y));
        result.x /= gcd;
        result.y /= gcd;

        return result;
    }

    /**
     * Euclids alogrithm for greatest common denominator
     * @param n1 - number 1
     * @param n2 - number 2
     * @return - value of greatest common denominator.
     */
    private int getGCD(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return getGCD(n2, n1 % n2);
    }

    /**
     * Move this coordinates by vector other
     * @param other - vector to move this coordinates by.
     */
    public void add(Direction other) {
        this.x+=other.x;
        this.y+=other.y;
    }

    @Override
    public String toString() {
        return Integer.toString((this.x*100)+this.y);
    }
}
