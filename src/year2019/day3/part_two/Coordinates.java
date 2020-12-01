package year2019.day3.part_two;

import java.util.Objects;

public class Coordinates {
    int x;
    int y;
    int stepnum;

    public Coordinates(int x, int y, int steps) {
        this.x = x;
        this.y = y;
        stepnum = steps;
    }

    public int manhattanDistance() {
        return Math.abs(x)+Math.abs(y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

//    @Override
//    public boolean equals(Object other) {
//        if (other instanceof Coordinates) {
//            Coordinates that = (Coordinates) other;
//            return ((this.x==that.x)&&(this.y==that.y));
//        }
//        return false;
//    }
}
