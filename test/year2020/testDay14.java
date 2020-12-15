package year2020;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import year2020.day14.FloatingMask;
import year2020.day14.Mask;
import year2020.day14.Part1;
import year2020.day14.Part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class testDay14 {

    @Test
    public void testPart1() {
        Scanner scanner = Util.parseInput("testResources/year2020/input14.txt");
        Assertions.assertEquals(165, Part1.solve(scanner));
    }

    @Test
    public void testPart2() {
        Scanner scanner = Util.parseInput("testResources/year2020/input14a.txt");
        Assertions.assertEquals(208, Part2.solve(scanner));
    }

    @Test
    public void testFloatingMaskOne() {
        Scanner scanner = Util.parseInput("testResources/year2020/input14a.txt");
        Mask mask = new FloatingMask(Mask.parseMask(scanner.nextLine()));
        ArrayList<Long> result = mask.applyMask(42);
        ArrayList<Long>  properResult= new ArrayList<>(Arrays.asList(26L, 27L, 58L, 59L));
        Assertions.assertTrue(result.containsAll(properResult));
        Assertions.assertTrue(properResult.containsAll(result));
    }

    @Test
    public void testFloatingMaskTwo() {
        Scanner scanner = Util.parseInput("testResources/year2020/input14a.txt");
        scanner.nextLine();
        scanner.nextLine();
        Mask mask = new FloatingMask(Mask.parseMask(scanner.nextLine()));
        ArrayList<Long> result = mask.applyMask(26);
        ArrayList<Long>  properResult= new ArrayList<>(Arrays.asList(16L, 17L, 18L, 19L, 24L, 25L, 26L, 27L));
        Assertions.assertTrue(result.containsAll(properResult));
        Assertions.assertTrue(properResult.containsAll(result));
    }

}
