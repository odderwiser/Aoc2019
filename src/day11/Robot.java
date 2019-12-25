package day11;

public class Robot {
    Point location;
    Direction direction;
    Map map;

    public Robot() {
        this.map = new Map();
        this.location = new Point(0, 0);
        map.add(location);
        this.direction = new Direction(0, 1);
    }

    public void move(boolean turnDir) {
        if (turnDir) {
            direction.turnRight();
            location.add(direction);
            map.add(direction);
        }
    }
}
