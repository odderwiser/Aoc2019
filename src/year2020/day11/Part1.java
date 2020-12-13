package year2020.day11;

public class Part1 {

    public static void main(String[] args) {
        Ferry ferry = new FerryAdjacent();
        Util.parseInput("resources/input11.txt", ferry);
        int result = Util.solve(ferry);
        System.out.println(result);
    }

}
