package year2020.day16;

import year2020.Util;

import java.util.Arrays;
import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) {
        Scanner scanner = Util.parseInput("resources/input16.txt");
        System.out.println(solve(scanner));

    }

    public static int solve(Scanner scanner) {
        Ticket ticket = new Ticket(scanner);
        scanner.nextLine();
        scanner.nextLine();
        scanner.nextLine();
        scanner.nextLine();
        int result = 0;
        while (scanner.hasNextLine()) {
            Integer[] line = Arrays.stream(scanner.nextLine().split(","))
                    .map(Integer::parseInt).toArray(Integer[]::new);
            result+=ticket.OutOfRange(line).stream().reduce(0, Integer::sum);
        }
        return result;
    }
}
