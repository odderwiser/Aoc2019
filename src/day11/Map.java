package day11;

import java.util.HashSet;

public class Map {
    HashSet<Point> points;

    public Map() {
        points = new HashSet<>();
    }

    public void add(Point point) {
        points.add(point);
    }
}
