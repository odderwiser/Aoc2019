package day10;

import java.util.Objects;

public class Coords implements Comparable<Coords>{
    int x;
    int y;
    double distance;

    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
        this.distance = 0;
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

    public void setDistance(Coords station) {
        this.distance = Math.sqrt(Math.pow((this.x - station.x), 2)+ Math.pow((this.y - station.y), 2));
    }

    public double getRotation() {
        if ((x >= 0) && (y < 0 )) {
            return (Math.abs(x)/distance);

        } else if ((x > 0) && (y >= 0)) {
            return (1 + (Math.abs(y)/distance));
        } else if ((x <= 0)&& (y > 0)) {
            return (2+ Math.abs(x)/distance);
        } else {
            return (3+ Math.abs(y)/distance);
        }
    }


    @Override
    public int compareTo(Coords other) {
        return Double.compare(this.getRotation(), other.getRotation());
    }

    @Override
    public String toString() {
        return Integer.toString((this.x*100)+this.y);
    }
}
