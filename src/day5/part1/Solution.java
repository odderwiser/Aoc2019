package day5.part1;

import java.util.Scanner;

public class Solution {
    static Scanner scanner;
    static int input = 1;

    public static void main(String[] args) {
        scanner = new Scanner(Solution.class.getResourceAsStream("/day5/input5.txt"));
        String[] stringcode = scanner.nextLine().split(",");
        Integer[] intcode = new Integer[stringcode.length];
        for (int i = 0; i < intcode.length; i++) {
            intcode[i] = Integer.parseInt(stringcode[i]);
        }
        solve(intcode);
    }

    public static void solve(Integer[] intcode){
        int i = 0;
        while (i < intcode.length) {
            Instruction command = new Instruction(intcode[i], intcode);
            i++;
            i = command.execute(i);
        }
        return;
    }
}
