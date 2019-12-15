package day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testCoords {

    @Test
    public void testDistance1() {
        Coords station = new Coords(0, 0);
        Coords checking = new Coords (0, -1);
        checking.setDistance(station);
        Assertions.assertEquals(1, checking.distance);
    }
    @Test
    public void testDistance2() {
        Coords station = new Coords(0, 0);
        Coords checking = new Coords (1, -1);
        checking.setDistance(station);
        Assertions.assertEquals(Math.sqrt(2.0), checking.distance);
    }

    @Test
    public void testRotation1() {
        Coords station = new Coords(0, 0);
        Coords checking = new Coords (0, -1);
        checking.setDistance(station);
        Assertions.assertEquals(0, checking.getRotation());
    }

    @Test
    public void testRotation2() {
        Coords station = new Coords(0, 0);
        Coords checking = new Coords (1, -1);
        checking.setDistance(station);
        Assertions.assertEquals(1/Math.sqrt(2), checking.getRotation());
    }

    @Test
    public void testRotation3() {
        Coords station = new Coords(0, 0);
        Coords checking = new Coords (1, 0);
        checking.setDistance(station);
        Assertions.assertEquals(1, checking.getRotation());
    }

    @Test
    public void testRotation4() {
        Coords station = new Coords(0, 0);
        Coords checking = new Coords (1, -1);
        checking.setDistance(station);
        Assertions.assertEquals(1/Math.sqrt(2), checking.getRotation());
    }

    @Test
    public void testRotation5() {
        Coords station = new Coords(11, -1);
        Coords checking = new Coords (11, -2);
        checking.setDistance(station);
        checking  = station.getGcd(checking);
        checking.setDistance(station);
        Assertions.assertEquals(0, checking.getRotation());
    }

    @Test
    public void testComparing1() {
        Coords station = new Coords(11, -1);
        Coords checking = new Coords (1, -1);
        checking.setDistance(station);
        Assertions.assertEquals(1+ 1/Math.sqrt(2), checking.getRotation());
    }
}
