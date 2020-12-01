package year2019.day9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class testPart1 {


    @Test
    public void test1() {
        int[] intcode = { 1102,34915192,34915192,7,4,7,99,0};
        long[] longcode = Arrays.stream(intcode).mapToLong(i -> i).toArray();

        ResultTuple result = Util.solve(longcode, new LinkedList<>());
        String res = Long.toString(result.get());
        Assertions.assertEquals(res.length(), 16);
    }

    @Test
    public void test2() {
        int[] intcode = {109,1,204,-1,1001,100,1,100,1008,100,16,101,1006,101,0,99};
        long[] longcode = Arrays.stream(intcode).mapToLong(i -> i).toArray();

        ResultTuple result = Util.solve(longcode, new LinkedList<>());
        long[] res = result.getArray();
        Assertions.assertArrayEquals(longcode, res);
    }
}
