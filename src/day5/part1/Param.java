package day5.part1;

public class Param {
    boolean mode;

    public Param(int mode) {
        if (mode == 0) {
            this.mode = false;
        } else {
            this.mode = true;
        }
    }

    public int execute(Integer[] intcode, int i) {
        if (mode) {
            return i;
        }
        return intcode[i];
    }
}
