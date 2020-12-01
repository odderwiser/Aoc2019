package day7;

import java.util.Arrays;
import java.util.LinkedList;

public class part1 {
    private static Integer[] inputArray = {0, 1, 2, 3, 4};
    private static Integer[] intcode;

    public static void main(String[] args) {
        intcode = Solution.parseInput();
        LinkedList<LinkedList<Integer>> combinations = Solution.generateInputs(inputArray);
        int result = getMax(combinations);
        System.out.println("The final value is: "+result);

    }

    //ok więc? każdy amplifier ma dwa wejścia. I trzeba zrobić solve 5 razy, za każdym razem dwa inputy:
    //input z tabelki i input będacy outputem.


    private static int getMax(LinkedList<LinkedList<Integer>> combinations) {
        int result = Integer.MIN_VALUE;
        for (LinkedList<Integer> code : combinations) {
            int output = 0;
            for (Integer value : code) {
                LinkedList<Integer> input = new LinkedList<>(Arrays.asList(value, output));
                output = solve(intcode.clone(), input);
            }
            if (output > result) {
                result = output;
            }
        }
        return result;
    }

    /**
     * Method to solve the problem
     * @param intcode = array of integers, the input code
     * @param input = initializing value for instruction 3
     * @return - the value outputed by instruction 4
     */
    static int solve(Integer[] intcode, LinkedList<Integer> input){
        //initialize pointer with 0 and loop over the input instructions
        ResultTuple result = new ResultTuple();
        int i = 0;
        while (i < intcode.length) {
            Instruction command = new Instruction(intcode[i], intcode, result, input);
            i++;
            i = command.execute(i);
        }
        return result.get();
    }

}
