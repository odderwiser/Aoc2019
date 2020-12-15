package year2020.day14;

import java.util.ArrayList;

public abstract class Mask {
    String mask;

    public Mask(String m) {
        this.mask = m;
        shortenMask();
    }

    public static String parseMask(String line) {
        if (line.startsWith("mask")) { ;
            return line.split(" = ")[1];
        }
        return "";
    }

    abstract void shortenMask();

    public abstract ArrayList<Long> applyMask(long value);


}
