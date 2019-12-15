package day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Station {
    Asteroid station;
    Map mother;
    HashMap<Coords, LinkedList<Asteroid>> shooting;
    ArrayList<Coords> clock;

    public Station(Map map, Asteroid station) {
        this.mother = map;
        this.station = station;
    }
}
