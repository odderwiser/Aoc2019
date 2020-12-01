package day12;

import java.util.ArrayList;

public class Map {
    ArrayList<day12.Moon> moons;

    public Map() {
        moons = new ArrayList<>();
    }

    public void add(String positon) {
        moons.add(new day12.Moon(positon));
    }

    public void applyGravity() {
        for (int i = 0; i < moons.size()-1; i++) {
            for (int j = i+1; j < moons.size(); j++) {
                moons.get(i).applyGravity(moons.get(j));
            }
        }
    }

    public void applyVelocity() {
        for (day12.Moon moon: moons) {
            moon.applyVelocity();
        }
    }

    public int getEnergy() {
        int sum = 0;
        for (day12.Moon moon: moons) {
            sum+=moon.getEnergy();
        }
        return sum;
    }
}
