package year2019.day12;

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
        for (int i = 0; i < this.position.length(); i++ ) {
            int sign = Integer.signum(Integer.compare(other.position.get(i), this.position.get(i)));
            this.velocity.add(i, sign);
            other.velocity.add(i, -sign);
        }
    }

    public void applyVelocity() {
        this.position.add(velocity);
    }

    public int getEnergy() {
        return position.getEnergy() * velocity.getEnergy();
    }
}
