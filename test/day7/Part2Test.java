package day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class Part2Test {

    @Test
    void testInput1() {
        Integer[] input = {3,26,1001,26,-4,26,3,27,1002,27,2,27,1,27,26,
                27,4,27,1001,28,-1,28,1005,28,6,99,0,0,5};
        LinkedList<Integer> combination = new LinkedList<>(Arrays.asList(9,8,7,6,5));
        int result = part2.checkCombination(combination, input);
        Assertions.assertEquals( 139629729, result);
    }
}
