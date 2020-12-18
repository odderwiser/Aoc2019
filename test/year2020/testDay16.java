package year2020;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import year2020.day16.Field;
import year2020.day16.Part1;
import year2020.day16.Part2;
import year2020.day16.Ticket;

import java.util.Scanner;

public class testDay16 {

    @Test
    public void testPart1() {
        Scanner scanner = Util.parseInput("testResources/year2020/input16.txt");
        Assertions.assertEquals(71, Part1.solve(scanner));
    }

    @Test
    public void testPart2() {
        Scanner scanner = Util.parseInput("testResources/year2020/input16a.txt");
        Ticket ticket = new Ticket(scanner);
        int[] myTicket = Part2.getMyTicket(scanner);
        Part2.solve(scanner, ticket);
        for (Field field: ticket.getFields()) {
            System.out.println("field: "+field.getName());
            for (Integer integer: field.getPossibleFieldNums()) {
                System.out.println(integer);
            }
        }
        Assertions.assertTrue(ticket.areFieldsDetermined());
    }

    @Test
    public void testPart2a() {
        Scanner scanner = Util.parseInput("resources/input16.txt");
        Ticket ticket = new Ticket(scanner);
        int[] myTicket = Part2.getMyTicket(scanner);
        Part2.solve(scanner, ticket);
        for (Field field: ticket.getFields()) {
            System.out.println("field: "+field.getName());
            for (Integer integer: field.getPossibleFieldNums()) {
                System.out.println(integer);
            }
        }
        Assertions.assertTrue(ticket.areFieldsDetermined());
    }
}
