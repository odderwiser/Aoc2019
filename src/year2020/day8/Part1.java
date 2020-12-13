package year2020.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner("dummyScannerObject");
        try {
            scanner = new Scanner(new File("resources/input08.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        ArrayList<Instruction> instructions = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            instructions.add(new Instruction(line[0], Integer.parseInt(line[1])));
        }
        IntNode result = new IntNode(0);
        IntNode counter = new IntNode(0);
        while(!instructions.get(counter.value).isVisited()) {
            instructions.get(counter.value).execute(counter, result);
        }
        System.out.println(result.value);
    }
}
