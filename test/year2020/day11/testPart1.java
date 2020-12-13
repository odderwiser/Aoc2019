package year2020.day11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testPart1 {

    @Test
    public void test1_1() {
        Ferry ferry = new FerryAdjacent();
        Util.parseInput("testResources/year2020/input11.txt", ferry);
        Assertions.assertEquals(37, Util.solve(ferry));
    }
}
