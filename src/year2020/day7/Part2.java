package year2020.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) {
        //initialise scanner
        Scanner scanner = new Scanner("dummyScannerObject");
        try {
            scanner = new Scanner(new File("resources/input07.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        // key - container bag, value - contained bag
        HashMap<String, LinkedList<Bag>> containers = new HashMap<>();

        //parse input
        while (scanner.hasNextLine()) {

            //parse line
            String line = scanner.nextLine();
            String[] splitLine = line.split(" ");

            //retrieve containter name
            String key = splitLine[0]+" "+splitLine[1];
            containers.put(key, new LinkedList<>());

            //if empty, skip next steps
            if (line.split("contain")[1].equals(" no other bags.")){
               continue;
            }

            //parse contained containers
            for (int i = 4; i< splitLine.length;) {
                int num = Integer.parseInt(splitLine[i]); //get number
                i++;
                Bag value = new Bag(num, splitLine[i]+" "+splitLine[++i]);
                i+=2; //skip to next number
                containers.get(key).add(value);
            }

        }
        //initialise breadth-first search
        LinkedList<Bag> queue = new LinkedList<>(containers.get("shiny gold"));
        long result = 0;

        while(!queue.isEmpty()) {
            //retrieve element from queue
            Bag bag = queue.removeFirst();
            //add the amount of bags to result only after retrieving from queue
            result += bag.getNumber();
            //in case bag contains other elements
            if (containers.containsKey(bag.getName())) {
                //multiply the number of each child-bags by the amount of parent-bags
                LinkedList<Bag> bags = containers.get(bag.getName());
                for (Bag b: bags) {
                    queue.add(b.multiply(bag));
                }
            }

        }
        System.out.println(result);
    }

}

