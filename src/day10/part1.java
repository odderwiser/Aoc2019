package day10;


public class part1 {

    public static void main(String[] args) {
        Map map = Util.parseInput("resources/input10.txt");
        System.out.println(map.asteroids.values().size());
        int result = Util.getBiggest(map);
        System.out.println("Result: "+ result);
    }

}
