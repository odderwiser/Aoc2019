package year2020.day11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class testPart2 {

    @Test
    public void test1_full() {
        Ferry ferry = new FerryInSight();
        Util.parseInput("testResources/year2020/input11.txt", ferry);
        Assertions.assertEquals(26, Util.solve(ferry));
    }

    @Test
    public void testFullyOccupied() {
        Ferry ferry = new FerryInSight();
        Util.parseInput("testResources/year2020/input11_FullyOccupied.txt", ferry);
        Assertions.assertEquals(Seat.EMPTY, ferry.seats.get(4).get(3));
        Assertions.assertEquals(8, ferry.countNeighbours(4, 3));
        for (int i = 0; i < ferry.seats.size(); i++) {
            ArrayList<Seat> row = ferry.seats.get(i);
            for (int j = 0; j < row.size(); j++) {
                Seat seat = row.get(j);
                if (seat.equals(Seat.OCCUPIED)) {
                    Assertions.assertEquals(0, ferry.countNeighbours(i, j));
                }
            }
        }
    }

    @Test
    public void testNotOccupied() {
        Ferry ferry = new FerryInSight();
        Util.parseInput("testResources/year2020/input11_NotOccupied.txt", ferry);
        Assertions.assertEquals(Seat.EMPTY, ferry.seats.get(3).get(3));
        Assertions.assertEquals(0, ferry.countNeighbours(3, 3));
    }

}
