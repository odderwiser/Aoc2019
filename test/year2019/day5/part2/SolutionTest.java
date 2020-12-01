package year2019.day5.part2;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    /**
     * This is a test that runs the program on smaller input
     */
    public void test01() {
        Integer[] input = {3,9,8,9,10,9,4,9,99,-1,8};
        int result = Solution.solve(input, 17);
        Assertions.assertEquals(result, 0);
    }
}
