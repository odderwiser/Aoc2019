package year2019.day11;

public enum Color {
    BLACK(0L),
    WHITE(1L);

    private long value;
    Color(long value) {
        this.value = value;
    }

    public long toLong() {
        return value;
    }

    public static Color fromLong(Long value) {
        if(value == 0) {
            return BLACK;
        }else{
            return WHITE;
        }
    }
}
