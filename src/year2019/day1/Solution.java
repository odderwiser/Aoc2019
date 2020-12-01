package year2019.day1;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(Solution.class.getResourceAsStream("input.txt"));
        int result = 0;
        int fuel = 0;
        while(scanner.hasNext()) {
            fuel=solve(scanner.nextInt());
            result+=fuel;
            while(fuel>0) {
                fuel = solve(fuel);
                result+=fuel;
            }
        }
        System.out.println("result: " +result);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int solve(int module) {
        return Math.max(0, module/3 - 2);
    }
}
