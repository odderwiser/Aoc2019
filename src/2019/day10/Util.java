package day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Util {

    public static Map parseInput(String filename) {
        try {
            Scanner scan = new Scanner(new File(filename));
            Map result = new Map();
            int y = 0;
            while (scan.hasNext()) {
                char[] row = scan.nextLine().toCharArray();
                for (int x = 0; x < row.length; x++) {
                    if (row[x] == '#') {
                        result.add(new Asteroid(x, y, result));
                    }
                }
                y++;
            }
            return result;
        } catch (FileNotFoundException e) {
            System.out.println("you tried");
            return null;
        }
    }

    public static int getBiggest(Map map) {
        int result = Integer.MAX_VALUE;
        for (Asteroid asteroid : map.asteroids.values()) {
            map.setAsteroidInvisibles(asteroid);
            result = Math.min(result, asteroid.invisible.size());
        }

        result = map.asteroids.size() - result;
        return result;
    }


}
