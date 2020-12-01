package year2019.day12;

public class Point {
    int[] coords;


    public Point(int x, int y, int z) {
        coords = new int[]{x, y, z};
    }

    public Point(String parsing) {
        parsing = parsing.substring(1, parsing.length()-1);
        String[] inter = parsing.split(",");
        for (int i = 0; i < inter.length; i++) {
            inter[i] = inter[i].split("=")[1];
        }
        coords = new int[]{Integer.parseInt(inter[0]), Integer.parseInt(inter[1]), Integer.parseInt(inter[2])};
    }

    public void add(Point other) {
        for (int i = 0; i < this.coords.length; i++) {
            this.coords[i] += other.coords[i];
        }
    }

    public int length() {
        return coords.length;
    }

    public int get(int index) {
        return coords[index];
    }

    public void add(int index, int value) {
        coords[index] += value;
    }

    public int getEnergy() {
        int sum = 0;
        for (Integer index : coords) {
            sum+=Math.abs(index);
        }
        return sum;
    }
}
