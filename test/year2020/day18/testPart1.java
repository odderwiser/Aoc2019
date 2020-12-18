package year2020.day18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import year2020.IntBox;

public class testPart1 {

    @CsvSource(value = {
            "1 + (2 * 3) + (4 * (5 + 6))-51",
            "1 + 2 * 3 + 4 * 5 + 6-71",
            "2 * 3 + (4 * 5)-26",
            "5 + (8 * 3 + 9 + 3 * 4 * 3)-437",
            "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))-12240",
            "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2-13632",
            "(1+1)+(1+1)+(1+1)-6",
            "((1+1)+(1+1))+1-5"
    }, delimiter = '-')

    @CsvFileSource(resources = "/year2020/input18_J.csv", delimiter = '-')

    @ParameterizedTest
    public void testSumArray(String line, long expected) {
        char[] arr = line.replaceAll(" ", "").toCharArray();
        Assertions.assertEquals(expected, Part1.sumArray(new IntBox(0), arr));
    }
}
