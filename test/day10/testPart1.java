package day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class testPart1 {

    @Test
    public void test1_1() {
        Map map = Util.parseInput("../resources/input_10_1_01.txt");
        System.out.println(map.sizeX +" "+map.sizeY);
        int result = Util.getBiggest(map);
        Assertions.assertEquals(33, result);
    }

    @Test
    public void test1_2() {
        Map map = Util.parseInput("../resources/input10_1_02.txt");
        System.out.println(map.sizeX +" "+map.sizeY);
        int result = Util.getBiggest(map);
        Assertions.assertEquals(35, result);
    }

    @Test
    public void test1_3() {
        Map map = Util.parseInput("../resources/input10_1_03.txt");
        System.out.println(map.sizeX +" "+map.sizeY);
        int result = Util.getBiggest(map);
        Assertions.assertEquals(41, result);
    }

    @Test
    public void test1_4() {
        Map map = Util.parseInput("../resources/input10_1_04.txt");
        System.out.println(map.sizeX +" "+map.sizeY);
        int result = Util.getBiggest(map);
        Assertions.assertEquals(210, result);
    }
}
