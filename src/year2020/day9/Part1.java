package year2020.day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) {
        //prepare scanner
        Scanner scanner = new Scanner("dummyScannerObject");
        try {
            scanner = new Scanner(new File("resources/input09.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        int preamble = 25; // how much previous values matter
        LinkedList<HashSet<Integer>> queue = new LinkedList<>(); //each entry is a hashset of nth number with next (preamble-1) numbers
        ArrayList<Integer> values = new ArrayList<>(); //list of all scanned values
        //read in the preamble
        for (int i = 0; i < preamble; i++) {
            values.add(Integer.parseInt(scanner.nextLine()));
        }
        //for all elems of preamble, generae hashsets for queue
        for (int i = 0; i < preamble; i++) {
            HashSet<Integer> sums = new HashSet<>();
            //for every element, sum it with |preamble| available next elements
            for (int j = i+1; j< preamble; j++) {
                sums.add(values.get(i)+values.get(j));
            }
            queue.add(sums);
        }
        int startIndex = 0; // used to keep track of the index of last meaningful value
        while (scanner.hasNextLine()) {
            //retieve value
            int value = Integer.parseInt(scanner.nextLine());

            //Search all the hashsets if the value already appeard.
            boolean found = false;
            for (HashSet<Integer> sums: queue) {
                if (sums.contains(value)) {
                    found = true;
                    break;
                }
            }

            if (found) {

                values.add(value);
                queue.removeFirst();
                startIndex++;
                int i = startIndex;
                for(HashSet<Integer> sums: queue) {
                    sums.add(value+values.get(i));
                    i++;
                }
                queue.add(new HashSet<>());
            } else {
                System.out.println(value);
                break;
            }
        }
    }
}
