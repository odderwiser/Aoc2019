package year2020.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Part1 {

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
        int ones = 0;
        int threes = 0;
        int currentValue = 0;
        while (adapters.size()>0) {
            int nextValue = adapters.poll();
            if (currentValue+1 == nextValue){
                ones++;
            } else if (currentValue+3 == nextValue) {
                threes++;
            }
            currentValue = nextValue;
        }
        threes++;
        System.out.println(ones*threes);
    }

}
