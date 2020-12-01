package day10;

public class part2 {

    public static void main(String[] args) {

        Map map = Util.parseInput("resources/input10.txt");
        System.out.println(map.asteroids.values().size());
        Util.getBiggest(map);
        Asteroid station = map.getAndRemoveStation();
        Station stat = new Station(map, station);
        Point result = destroyAsteroids(stat, 200);
        System.out.println(result.toString());

    }

    static Point destroyAsteroids(Station station, int index) {
        int i = 1;
        while (i <= index) {

            for (Direction point : station.getDirections()) {
                System.out.print(i+" ");
                Point result = station.destroyClosestAsteroid(point);
                if (i == index) {
                    return result;
                }
                i++;
            }
        }
        return new Point(0,0);
    }
}
