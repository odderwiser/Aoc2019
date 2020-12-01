package year2019.day11;

public enum TurnDirection {
    LEFT,
    RIGHT;

    public static TurnDirection fromLong(long in) {
        switch ((int) in) {
            case 0: return LEFT;
            case 1: return RIGHT;
            default: throw new IllegalArgumentException();
        }
    }
}
