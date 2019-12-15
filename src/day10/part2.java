package day10;

public class part2 {

    public static void main(String[] args) {

        Map map = Util.parseInput("resources/input10.txt");
        System.out.println(map.asteroids.values().size());
        Util.getBiggest(map);
        Asteroid station = map.setStation();

    }

    //co będę potrzebować? hashmapa <cord, PQ<Asteroid>
    //+ posortowana lista lokacji wg kata
}
