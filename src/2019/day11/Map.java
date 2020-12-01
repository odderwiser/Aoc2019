package day11;

import java.util.HashMap;

public class Map {
    HashMap<Point, Color> points;
    int xMin;
    int xMax;
    int yMin;
    int yMax;

    public Map() {
        points = new HashMap<>();
        xMin = 0;
        yMin = 0;
        xMax = 0;
        yMax = 0;
    }

    public void set(Point point, Color color) {
        points.put(point, color);
        xMin = Math.min(xMin, point.x);
        xMax = Math.max(xMax, point.x);
        yMin = Math.min(yMin, point.y);
        yMax = Math.max(yMax, point.y);
    }

    public int countPainted() {
        return points.size();
    }

    public void print() {
        for (int j = yMax; j >= yMin; j--) {
            for (int i = xMin; i <= xMax; i++) {
                Point point = new Point(i, j);
                if (points.containsKey(point)) {
                    Color color = points.get(point);
                    if (color == Color.WHITE) {
                        System.out.print("#");
                    } else {
                        System.out.print(" ");
                    }
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }
}
