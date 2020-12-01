package year2019.day6.part1;

import java.util.ArrayList;

public class Planet {
    ArrayList<Planet> orbits;
    int counter;

    Planet() {
        orbits = new ArrayList<>();
        counter = 0;
    }

    void add(Planet orbit) {
        orbits.add(orbit);
    }

    void setCounter(int value) {
        this.counter = value;
    }

}
