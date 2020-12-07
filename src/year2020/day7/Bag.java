package year2020.day7;

public class Bag {
    private long number;
    private String name;

    Bag(int num, String name) {
        this.number = num;
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    Bag multiply(Bag other) {
        this.number *=other.number;
        return this;
    }
}
