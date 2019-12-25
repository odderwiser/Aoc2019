package day11;

public class Direction extends Point{

    public Direction(int x, int y) {
        super(x, y);
    }

    public void turnRight() {
        int xNext = 0;
        int yNext = 0;
        if (this.x == 0) {
            xNext = this.y;
        } else {
            yNext =  - this.x;
        }
        this.x = xNext;
        this.y = yNext;
    }

    public void turnLeft() {
        int xNext = 0;
        int yNext = 0;
        if (this.x == 0) {
            xNext = - this.y;
        } else {
            yNext = this.x;
        }
        this.x = xNext;
        this.y = yNext;
    }
}
