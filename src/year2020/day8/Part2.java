package year2020.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Part2 {

    public static void main(String[] args) {
        //set up scanner
        Scanner scanner = new Scanner("dummyScannerObject");
        try {
            scanner = new Scanner(new File("resources/input08.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        //parse input
        ArrayList<Instruction> instructions = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            instructions.add(new Instruction(line[0], Integer.parseInt(line[1])));
        }
        //I need to find an instruction before the loop, that could point to the tail.
        for(int i = 0; i< instructions.size(); i++) {
            Instruction instruction = instructions.get(i);
            int j = i;
            if (instruction.isJump()) {
                j+=instruction.value;
            } else {
                j++;
            }
            if (j < instructions.size()) {
                instruction.setNext(instructions.get(j));
            }
        }
        System.out.println("got to this part");
        IntNode result = new IntNode(0);
        IntNode counter = new IntNode(0);
        while(!instructions.get(counter.value).isVisited()) {
            instructions.get(counter.value).execute(counter, result);
        }
        System.out.println("got to this part");
        LinkedList<Instruction> queue = new LinkedList<>();
        queue.add(instructions.get(instructions.size()-1));
        while(!queue.isEmpty()){
            Instruction instruction = queue.removeFirst();
            instruction.tail = true;
            queue.addAll(instruction.previous.stream().filter(x -> !x.tail).collect(Collectors.toList()));
        }
        result = new IntNode(0);
        counter = new IntNode(0);
        System.out.println("got to this part");
        boolean unloopFound = false;
        while (counter.value < instructions.size()) {
            Instruction i = instructions.get(counter.value);
            if ((!unloopFound)&&instructions.get(counter.value+1).tail) {
                i.unloop();
                unloopFound = true;
            }
            i.execute(counter, result);
        }
        System.out.println(result.value);
    }
}
