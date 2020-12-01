package year2019.day7;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class part2 {
    private static Integer[] inputArray = {5, 6, 7, 8, 9};
    private static Integer[] intcode;

    public static void main(String[] args) {
        intcode = Solution.parseInput();
        System.out.println("instruction generated sucessfully "+intcode.length);

        LinkedList<LinkedList<Integer>> combinations = Solution.generateInputs(inputArray);
        System.out.println("combinations generated sucessfully "+combinations.size());

        int result = getMax(combinations);
        System.out.println("The final value is: "+result);

    }

    /**
     * finds the max output from all input combinations
     * @param combinations - list of possible inputs
     * @return -the highest ouptut
     */
    private static int getMax(LinkedList<LinkedList<Integer>> combinations) {
        //the highest value from all combinations
        int result = Integer.MIN_VALUE;

        //for each code in combinations
        for (LinkedList<Integer> code : combinations) {
            int output = checkCombination(code, intcode);
            if (output > result) {
                result = output;
            }
        }
        return result;
    }

    /**
     * Method to check the output of single combination
     * @param code - combination of input digits
     * @param intcode - instruction set
     * @return
     */
    static int checkCombination(LinkedList<Integer> code, Integer[] intcode) {
        //the list of amplifiers
        LinkedList<Amplifier> amplifiers = new LinkedList<>();
        //output of every amplifier
        int output = 0;
        //output of 5th amplifier
        int totalOutput = 0;
        //holds results
        ResultTuple result = new ResultTuple();

        //first iteration over amplifiers
        for (Integer value : code) {
            //generate two input values
            LinkedList<Integer> input = new LinkedList<>(Arrays.asList(value, output));
            //add a new amplifier to the list with new instruction set
            amplifiers.add(new Amplifier(intcode.clone()));
            //get the first output from the amplifier
            result = amplifiers.getLast().solve(input);
            if (result.isFinished()) {
                return totalOutput;
            }
            output = result.get();
        }
        totalOutput = output;
        //next iterations over amplifiers
        while (!result.isFinished()) {

            for (int i = 0; i < 5; i++) {
                //retrieve new amplifier
                Amplifier amp = amplifiers.get(i);
                //set input as the output of previous amplifier
                LinkedList<Integer> input = new LinkedList<>(Collections.singletonList(output));
                //retrieve next output or reach 99
                result = amp.solve(input);
                //if 99 was reached, return previously saved output of amplifier 5
                if (result.isFinished()) {
                    return totalOutput;
                }
                output = result.get();
            }
            totalOutput = output;
        }
        return totalOutput;
    }
}
