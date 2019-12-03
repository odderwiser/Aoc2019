package Day3.PartTwo;

import Day3.Dir;

import java.util.HashSet;

public class Directions {
    int distance;
    Dir direction;
    int stepcount;

    public Directions(String dirs, int stepcount) {
        char where = dirs.charAt(0);
        if (where=='R') {
            direction = Dir.Right;
        } else if (where=='L') {
            direction = Dir.Left;
        } else if (where == 'U') {
            direction = Dir.Up;
        } else if (where == 'D') {
            direction = Dir.Down;
        }
        distance = Integer.parseInt(dirs.substring(1));
        this.stepcount = stepcount;
    }

    public HashSet<Coordinates> makeMove(Coordinates current) {
        if (direction == Dir.Down){
            return down(distance, current);
        }
        if (direction == Dir.Up){
            return up(distance, current);
        }
        if (direction == Dir.Left){
            return left(distance, current);
        }
        if (direction == Dir.Right){
            return right(distance, current);
        } else {
            System.out.println("mistake");
            return new HashSet<>();
        }
    }

    public Coordinates newCoords(Coordinates current) {
        if (direction == Dir.Down){
            return new Coordinates(current.x, current.y-distance, 0);
        }
        if (direction == Dir.Up){
            return new Coordinates(current.x, current.y+distance, 0);
        }
        if (direction == Dir.Left){
            return new Coordinates(current.x-distance, current.y, 0);
        }
         return new Coordinates(current.x+distance, current.y, 0);

    }

    private HashSet<Coordinates> left(int num, Coordinates current) {
        HashSet<Coordinates> result = new HashSet<>();
        int step = 1;
        while (step < num) {
            result.add(new Coordinates(current.x-step, current.y, stepcount+step));
            step++;
        }
        return result;
    }

    private HashSet<Coordinates> right(int num, Coordinates current) {
        HashSet<Coordinates> result = new HashSet<>();
        int step = 1;
        while (step < num) {
            result.add(new Coordinates(current.x+step, current.y, stepcount+step));
            step++;
        }
        return result;
    }

    private HashSet<Coordinates> up(int num, Coordinates current) {
        HashSet<Coordinates> result = new HashSet<>();
        int step = 1;
        while (step < num) {
            result.add(new Coordinates(current.x, current.y+step, stepcount+step));
            step++;
        }
        return result;
    }

    private HashSet<Coordinates> down(int num, Coordinates current) {
        HashSet<Coordinates> result = new HashSet<>();
        int step = 1;
        while (step < num) {
            result.add(new Coordinates(current.x, current.y-step, stepcount+step));
            step++;
        }
        return result;
    }
}
