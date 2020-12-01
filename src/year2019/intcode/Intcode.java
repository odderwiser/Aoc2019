package year2019.intcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Intcode {
    static int[] sizes = { 0, 3, 3, 1, 1, 2, 2, 3, 3, 1 };
    private int relativeBase = 0;
    private long[] intcode;
    private int index = 0;

    public Intcode(String fileName) {
        intcode = Intcode.parseInput(fileName);
    }

    /**
     * Main method of class.
     */
    static long[] parseInput(String inputFile) {
        //retrieve and parse the input to array of strings
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(inputFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] stringcode = scanner.nextLine().split(",");

        //parse into array of longs
        long[] intcode = new long[stringcode.length];
        for (int i = 0; i < intcode.length; i++) {
            intcode[i] = Long.parseLong(stringcode[i]);
        }
        //set the initial value and solve
        return intcode;
    }

    /**
     * Method to solve the problem
     * @param input = initializing value for instruction 3
     * @return - the value outputed by instruction 4
     */
    public ResultTuple solve(LinkedList<Long> input){
        //initialize pointer with 0 and loop over the input instructions
        ResultTuple result = new ResultTuple();
        while (index < intcode.length) {
            Instruction command = new Instruction(intcode[index], intcode, result, input, relativeBase);
            index++;
            index = command.execute(index);
            relativeBase += command.getUpdateValue();
            intcode = command.intcode;
            if (result.check()) {
                return result;
            }
            if (result.isFinished()) {
                return result;
            }
        }
        return result;
    }
}
