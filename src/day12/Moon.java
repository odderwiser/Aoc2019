package day12;

public class Moon {
    Point position;
    Point velocity;

    public Moon(int x, int y, int z) {
        position = new Point(x, y, z);
        velocity = new Point(0, 0, 0);
    }

    public Moon(String position) {
        this.position = new Point(position);
        this.velocity = new Point(0, 0, 0);
    }

    public void applyGravity(Moon other) {
        this.velocity
    }
}
