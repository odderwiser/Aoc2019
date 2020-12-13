package year2020.day11;

public enum Seat {
    NULL('.'), EMPTY('L'), OCCUPIED('#');

    public final char label;

    private Seat(char label) {
        this.label = label;
    }

    public static char valueOfElem(Seat seat) {
        for (Seat e : values()) {
            if (e.equals(seat)) {
                return e.label;
            }
        }
        return '0';
    }

    public static Seat getValue(char c) {
        for (Seat e : values()) {
            if (e.label == c) {
                return e;
            }
        }
        return Seat.NULL;
    }
}
