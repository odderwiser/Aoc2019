package year2020.day7;

public class Bag {
    private long number;
    private String name;

    Bag(long num, String name) {
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
        return new Bag(this.number*other.number, this.name);
    }
}
