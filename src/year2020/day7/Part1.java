package year2020.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner("dummyScannerObject");
        try {
            scanner = new Scanner(new File("resources/input07.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        HashMap<String, HashSet<String>> containers = new HashMap<>(); // key - contained bag, value - containing bag
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.split("contain")[1].equals(" no other bags.")){
                continue;
            }
            String[] splitLine = line.split(" ");
            String value = splitLine[0]+" "+splitLine[1];
            for (int i = 4; i< splitLine.length;) {
                i++; //skip the number
                String key = splitLine[i]+" "+splitLine[++i];
                i+=2;
                if (!containers.containsKey(key)) {
                    containers.put(key, new HashSet<>());
                }
                containers.get(key).add(value);
            }

        }
        LinkedList<String> queue = new LinkedList<>(containers.get("shiny gold"));
        HashSet<String> result = new HashSet<>();
        while(!queue.isEmpty()) {
            //if element from queue is result, skip.
            //else, add to result and add the linkedlist to queue
            String key = queue.removeFirst();
            if (!result.contains(key)){
                result.add(key);
                if (containers.containsKey(key)) {
                    queue.addAll(containers.get(key));
                }
            }
        }
        System.out.println(result.size());

    }

}
