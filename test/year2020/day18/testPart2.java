package year2020.day18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import year2020.IntBox;

import java.util.regex.Pattern;

public class testPart2 {

    @CsvFileSource(resources = "/year2020/input18_part2.csv")

    @ParameterizedTest
    public void testParseOperation(String line, long expected) {
        String operation = line.replaceAll(" ", "");
        String result = Part2.parseOperation(operation);
        Assertions.assertTrue(Pattern.compile("\\d+").matcher(result).matches());
        Assertions.assertEquals(expected, Long.parseLong(result));
    }
}
