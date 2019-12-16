package day10;

public class Direction extends Coords implements Comparable<Direction>{

    double distance;

    /**
     * Initialise coordinates
     *
     * @param x - x coordinate
     * @param y - y coordinate
     */
    public Direction(int x, int y) {
        super(x, y);
        setDistance();
    }

    /**
     * Set distance between this coordinates and station
     */
    public void setDistance() {
        this.distance = Math.sqrt(Math.pow((this.x), 2)+ Math.pow((this.y), 2));
    }

    /**
     * Get value 0-4 of how far this coordinate (as vector) is from pointing towards (0, -1), upwards.
     * Counted clockwise.
     * @return - Arbitrary value representing rotation.
     */
    public double getRotation() {
        //if vector point to I quater
        if ((x >= 0) && (y < 0 )) {
            return (Math.abs(x)/distance);

        } else if ((x > 0) && (y >= 0)) {
            //IV quater
            return (1 + (Math.abs(y)/distance));
        } else if ((x <= 0)&& (y > 0)) {
            //III quater
            return (2+ Math.abs(x)/distance);
        } else {
            //II quater
            return (3+ Math.abs(y)/distance);
        }
    }

    @Override
    public int compareTo(Direction other) {
        return Double.compare(this.getRotation(), other.getRotation());
    }
}
