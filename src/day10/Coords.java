package day10;

import java.util.Objects;

public class Coords {
    int x;
    int y;

    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

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

    public Coords getGcd(Coords other) {
        Coords result = new Coords(other.x - this.x, other.y - this.y);

        //if they're on the same line
        if (result.x == 0) {
            return new Coords(0, Integer.signum(result.y));
        }
        if (result.y == 0) {
            return new Coords(Integer.signum(result.x), 0);
        }

        int gcd = euclids(Math.abs(result.x), Math.abs(result.y));
        result.x /= gcd;
        result.y /= gcd;

        return result;
    }

    private int euclids(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return euclids(n2, n1 % n2);
    }

    public void add(Coords other) {
        this.x+=other.x;
        this.y+=other.y;
    }
}
