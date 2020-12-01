package day8.part2;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(day8.part1.Solution.class.getResourceAsStream("/2019/day8/input8.txt"));
        char[] input = scanner.nextLine().toCharArray();
        Picture result = parseInput(input);
        System.out.println(result.toString());

    }

    public static Picture parseInput(char[] digits) {
        Picture picture = new Picture();

        for (char c : digits) {
           picture.putPixel(c);
        }

        return picture;
    }
}
