package year2020.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {
        //prepare scanner
        Scanner scanner = new Scanner("dummyScannerObject");
        try {
            scanner = new Scanner(new File("resources/input10.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        PriorityQueue<Integer> adapters = new PriorityQueue<>();
        while (scanner.hasNextInt()) {
            adapters.add(scanner.nextInt());
        }
        HashMap<Integer, Long> validCombinations = new HashMap<>();
        validCombinations.put(0, 1l);
        while (adapters.size() > 0) {
            int adapter = adapters.poll();
            System.out.println("adapter: "+adapter);
            //for every value, you can add or not add the adapter.
            //if becomes too small, discard.
            long newValue = 0;
            int toRemove = -1;
            for (Integer i: validCombinations.keySet()) {
                System.out.println(i+" "+validCombinations.get(i));
                if (adapter - i >3) {
                    toRemove = i;
                } else {
                    newValue += validCombinations.get(i);
                }
            }
            System.out.println("new value: "+adapter+" "+newValue);
            validCombinations.put(adapter, newValue );
            if (toRemove > 0) {
                validCombinations.remove(toRemove);
            }
        }
        long value = validCombinations.get(validCombinations.keySet().stream().max(Integer::compare).get());
        System.out.println(value);
    }
}
