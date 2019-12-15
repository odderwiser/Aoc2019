package day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testPart2 {

    @Test
    public void test1_4() {
        Map map = Util.parseInput("../resources/input10_1_04.txt");
        System.out.println(map.xSize+" "+map.ySize);
        Util.getBiggest(map);
        Asteroid station = map.setStation();
        Station stat = new Station(map, station);
        Coords result = part2.destroy(stat, 200);
        Assertions.assertEquals(802, result.toString());
    }
}
