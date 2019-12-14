package day9;

import java.util.Collections;
import java.util.LinkedList;

public class part1 {

    public static void main(String[] args) {
        long[] intcode = Util.parseInput();
        LinkedList<Long> input = new LinkedList<>(Collections.singletonList((long) 1));
        ResultTuple result = Util.solve(intcode, input);
        System.out.println(result.get());
    }
}
