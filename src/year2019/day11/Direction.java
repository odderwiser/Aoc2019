package year2019.day11;

public enum Direction {
    NORTH(0, 1),
    EAST(1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);

    int x;
    int y;
    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Direction turn(TurnDirection dir) {
        if(dir == TurnDirection.LEFT){
            return left();
        }else {
            return right();
        }
    }

    public Direction left() {
        switch(this) {
            case NORTH: return WEST;
            case EAST: return NORTH;
            case SOUTH: return EAST;
            case WEST: return SOUTH;
        }
        return null;
    }

    public Direction right() {
        switch(this) {
            case NORTH: return EAST;
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST: return NORTH;
        }
        return null;
    }
}
