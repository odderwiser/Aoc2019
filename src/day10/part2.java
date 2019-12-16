package day10;

public class part2 {

    public static void main(String[] args) {

        Map map = Util.parseInput("resources/input10.txt");
        System.out.println(map.asteroids.values().size());
        Util.getBiggest(map);
        Asteroid station = map.getStation();
        Station stat = new Station(map, station);
        Coords result = destroy(stat, 200);
        System.out.println(result.toString());

    }

    static Coords destroy(Station station, int index) {
        int i = 1;
        while (i <= index) {

            for (Coords coords: station.getKeySet()) {
                System.out.print(i+" ");
                Coords result = station.destroy(coords);
                if (i == index) {
                    return result;
                }
                i++;
            }
        }
        return new Coords(0,0);
    }
}
