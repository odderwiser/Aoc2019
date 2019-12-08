package day7;

import java.util.LinkedList;
import java.util.Optional;

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
        //initialize pointer with 0 and loop over the input instructions
        ResultTuple result = new ResultTuple();
        while (i < intcode.length) {
            Instruction command = new Instruction(intcode[i], intcode, result, input);
            i++;
            i = command.execute(i);
            if (result.check()) {
                System.out.println("new amplifier "+result.isFinished());
                return result;
            }
            System.out.println("Now i is: "+i);
        }
        return result;
    }


}
