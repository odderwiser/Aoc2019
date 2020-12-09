package year2020.day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("dummyScannerObject");
        try {
            scanner = new Scanner(new File("resources/input09.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        int preamble = 25;
        LinkedList<HashSet<Integer>> queue = new LinkedList<>();
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 0; i < preamble; i++) {
            values.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < preamble; i++) {
            HashSet<Integer> sums = new HashSet<>();
            for (int j = i+1; j< preamble; j++) {
                sums.add(values.get(i)+values.get(j));
            }
            queue.add(sums);
        }
        int startIndex = 0;
        int sum = 0;
        while (scanner.hasNextLine()) {
            int value = Integer.parseInt(scanner.nextLine());
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
                sum = value;
                break;
            }
        }
        HashSet<Integer> sums = new HashSet<>();
        for (int i = 0; i < values.size(); i++) {
            int tempSum = sum;
            for (int j = i; tempSum > 0; j++) {
                tempSum-=values.get(j);
                sums.add(values.get(j));
            }
            if (tempSum==0) {
                break;
            } else {
                sums = new HashSet<>();
            }
        }
        int min = sums.stream().min(Integer::compare).get();
        int max = sums.stream().max(Integer::compare).get();
        System.out.println(min+max);
    }
}
