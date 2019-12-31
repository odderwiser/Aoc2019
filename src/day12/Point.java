package day12;

public class Point {
    int x;
    int y;
    int z;


    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(String parsing) {
        parsing = parsing.substring(1, parsing.length()-1);
        String[] inter = parsing.split(",");
        for (int i = 0; i < inter.length; i++) {
            inter[i] = inter[i].split("=")[1];
        }
        this.x = Integer.parseInt(inter[0]);
        this.y = Integer.parseInt(inter[1]);
        this.z = Integer.parseInt(inter[2]);
    }

    public void add(Point other) {
        this.x = this.x + other.x;
        this.y = this.y + other.y;
        this.z = this.z + other.z;
    }
}
