package year2020.day14;

import year2020.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) {
        Scanner scanner = Util.parseInput("resources/input14.txt");
        long result = solve(scanner);
        System.out.println(result);
    }

    public static long solve(Scanner scanner) {
        HashMap<Long, Long> addresses = new HashMap<>();
        Mask mask = new FloatingMask("");
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" = ");
            if (line[0].startsWith("mask")) {
                mask = new FloatingMask(line[1]);
            } else if (line[0].startsWith("mem")) {
                long address = Long.parseLong(line[0].split("\\[|\\]")[1]);
                ArrayList<Long> locations = mask.applyMask(address);
                long value = Long.parseLong(line[1]);
                for (Long loc: locations) {
                    addresses.put(loc, value);
                }
            }
        }
        long result =0;
        for (long value: addresses.values()) {
            result+=value;
        }
        return result;
    }
}
