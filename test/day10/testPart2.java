package day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class testPart2 {

    @Test
    public void test1_4() {
        Map map = Util.parseInput("../resources/input10_1_04.txt");
        System.out.println(map.xSize+" "+map.ySize);
        Util.getBiggest(map);
        Asteroid station = map.getStation();
        Station stat = new Station(map, station);
        Coords result = part2.destroy(stat, 200);
        Assertions.assertEquals("802", result.toString());
    }

    @Test
    public void test2_01() {
        Map map = Util.parseInput("../resources/input10_2_01.txt");
        System.out.println(map.xSize+" "+map.ySize);
        Util.getBiggest(map);
        Asteroid station = map.getStation();
        Station stat = new Station(map, station);
        Coords result = part2.destroy(stat, 1);
        Assertions.assertEquals("300", result.toString());
    }

    @CsvSource({
            "1, 300",
            "2, 501",
            "3, 602",
            "4, 503",
            "5, 304",
            "6, 103",
            "7, 2",
            "8, 101",
            "9, 702"
    })

    @ParameterizedTest
    public void test2_02(int index, String expected) {
        Map map = Util.parseInput("../resources/input10_2_01.txt");
        System.out.println(map.xSize+" "+map.ySize);
        Util.getBiggest(map);
        Asteroid station = map.getStation();
        Station stat = new Station(map, station);
        Coords result = part2.destroy(stat, index);
        Assertions.assertEquals(expected, result.toString());
    }
}
