package day7;

import java.util.LinkedList;
import java.util.Optional;

/**
 * Represents amplifier, has own instructions and counter
 */
public class Amplifier {
    Integer[] intcode;
    int i;

    Amplifier(Integer[] intcode) {
        this.intcode = intcode;
        this.i = 0;
    }

    /**
     * Method to solve the problem
     * @param input = initializing value for instruction 3
     * @return - the value outputed by instruction 4
     */
    ResultTuple solve( LinkedList<Integer> input){
        //result type
        ResultTuple result = new ResultTuple();
        //while instruction not finished
        while (i < intcode.length) {
            //generate and execute command
            Instruction command = new Instruction(intcode[i], intcode, result, input);
            i++;
            i = command.execute(i);
            //if 99 of instruction was reached
            if (result.check()) {
                return result;
            }
        }
        return result;
    }


}
