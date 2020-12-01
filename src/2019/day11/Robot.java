package day11;

public class Robot {
    Point location;
    Direction direction;
    Map map;

    public Robot(Color startColor) {
        this.map = new Map();
        this.location = new Point(0, 0);
        map.set(location, startColor);
        this.direction = Direction.NORTH;
    }

    public void move(TurnDirection turnDir) {
        direction = direction.turn(turnDir);
        location = location.add(direction);
    }

    public int countPainted() {
        return map.countPainted();
    }

    public void paint (Color color) {
        map.set(location, color);
    }

    public Color getColor() {
        if (!map.points.containsKey(location)) return Color.BLACK;
        return map.points.get(location);
    }
}
