package year2020.day16;

import year2020.Util;

import java.util.*;

public class Part2 {

    public static void main(String[] args) {
        Scanner scanner = Util.parseInput("resources/input16.txt");
        Ticket ticket = new Ticket(scanner);
        int[] myTicket = getMyTicket(scanner);
        solve(scanner, ticket);
        System.out.println(calculateResult(ticket, myTicket));
    }

    public static int[] getMyTicket(Scanner scanner) {
        scanner.nextLine();
        int[] myTicket = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt).toArray();
        scanner.nextLine();
        scanner.nextLine();
        return myTicket;
    }

    public static long calculateResult(Ticket ticket, int[] myTicket) {
        long result = 1;
        for(Field field: ticket.getFields()) {
            if(field.name.startsWith("departure")) {
                result*=myTicket[field.possibleFieldNums.iterator().next()];
            }
        }
        return result;
    }


    public static void solve(Scanner in, Ticket ticket) {
        String line = in.nextLine();
        Integer[] nextLine = Arrays.stream(line.split(","))
                .map(Integer::parseInt).toArray(Integer[]::new);
        ticket.setSizeOfFields(nextLine.length);
        ticket.evaluateFields(nextLine);
        while(in.hasNextLine()) {
            nextLine = Arrays.stream(in.nextLine().split(","))
                    .map(Integer::parseInt).toArray(Integer[]::new);
            ticket.evaluateFields(nextLine);

            if(ticket.areFieldsDetermined()) {
                break;
            }
        }
    }
}
