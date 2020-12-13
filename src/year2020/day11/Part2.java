package year2020.day11;

public class Part2 {

    public static void main(String[] args) {
        Ferry ferry = new FerryInSight();
        Util.parseInput("resources/input11.txt", ferry);
        Util.solve(ferry);
        System.out.println(ferry.countSeats());
    }
}
