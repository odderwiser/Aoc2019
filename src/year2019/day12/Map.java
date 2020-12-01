package year2019.day12;

import java.util.ArrayList;

public class Map {
    ArrayList<Moon> moons;

    public Map() {
        moons = new ArrayList<>();
    }

    public void add(String positon) {
        moons.add(new Moon(positon));
    }

    public void applyGravity() {
        for (int i = 0; i < moons.size()-1; i++) {
            for (int j = i+1; j < moons.size(); j++) {
                moons.get(i).applyGravity(moons.get(j));
            }
        }
    }

    public void applyVelocity() {
        for (Moon moon: moons) {
            moon.applyVelocity();
        }
    }

    public int getEnergy() {
        int sum = 0;
        for (Moon moon: moons) {
            sum+=moon.getEnergy();
        }
        return sum;
    }
}
