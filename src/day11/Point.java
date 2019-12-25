package day11;

public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point add(Direction movement) {
        return new Point(this.x + movement.x, this.y + movement.y);
    }
}
