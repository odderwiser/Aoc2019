package year2019.day5.part2;

import java.util.ArrayList;

class Instruction {
    private int opcode;
    private Param[] params;
    private Integer[] intcode;
    private ArrayList<Integer> result;
    private int input;
    private int[] sizes;
    /**
     * This is the method constructor.
     * @param value - integer representing the opcode
     * @param intcode - array of all instructions
     * @param sizes - array of parameters amount per instruction
     * @param result - array that encapsulates reasult, if it is created
     * @param input - initialise value for instruction 3
     */
    Instruction(Integer value, Integer[] intcode, int[] sizes, ArrayList<Integer> result, int input) {
        this.result = result;
        this.intcode = intcode;
        this.input = input;
        this.sizes = sizes;
        parseOpCode(value);
    }

    /**
     * This is the method to parse opcode and retrieve instruction details
     * @param value - the value of opcode
     */
    private void parseOpCode(Integer value) {
        //parse value of opcode to string
        String val = value.toString();

        //retrieve the instruction number
        int length = val.length()-2;
        if(val.length()>1) {
            this.opcode = Integer.parseInt(val.substring(length));
        } else {
            this.opcode = value;
        }
        length--;

        //determine the amount of parameters
        if (opcode < 9) {
            params = new Param[sizes[opcode]];
        } else {
            params = new Param[0];
        }

        //initialise parameters with proper modes
        for (int i = 0; i < params.length; i++) {
            if (length >= 0) {
                params[i] = new Param((val.charAt(length)-'0'), intcode);
                length--;
            } else {
                params[i] = new Param(0, intcode);
            }
        }
    }

    /**
     * Switch statement to manage all instrucion codes
     * @param i - instruction pointer, pointing on the first param of instruction
     * @return - pointer pointing on the opcode of next instruction
     */
    int execute(int i) {
        switch(opcode) {
            case 1:
                i = codeOne(i);
                break;
            case 2:
                i = codeTwo(i);
                break;
            case 3:
                i = codeThree(i);
                break;
            case 4:
                i = codeFour(i);
                break;
            case 5:
                i = codeFive(i);
                break;
            case 6:
                i = codeSix(i);
                break;
            case 7:
                i = codeSeven(i);
                break;
            case 8:
                i = codeEight(i);
                break;
            case 99:
                //end the program
                System.out.println("opcode 99");
                return intcode.length;
            default:
                //in case opcode is invalid
                System.out.println("mistake");
                System.out.println(opcode+" "+i);
                return intcode.length;

        }
        return i;
    }

    /**
     * This is the method that adds param1 and param2
     * and stores them in location determined by param3.
     * @param i - Pointer of the first param
     * @return - pointer pointing to the next instruction
     */
    private int codeOne(int i) {
        //determine values of parameters
        int a = intcode[params[0].execute(i)];
        int b = intcode[params[1].execute(i+1)];

        //store the value
        intcode[intcode[i+2]] = (a + b);
        return i+3;
    }

    /**
     * This is the method that multiplies param1 and param2
     * and stores them in location determined by param3.
     * @param i - Pointer of the first param
     * @return - pointer pointing to the next instruction
     */
    private int codeTwo(int i) {
        //determine the value of both parameters
        int a = intcode[params[0].execute(i)];
        int b = intcode[params[1].execute(i+1)];

        //store the results
        intcode[intcode[i + 2]] = (a * b);
        return i+3;
    }

    /**
     * THis is the method that realises operation specified by instruction 3.
     * The method stores input parameter in the value specified by param1.
     * @param i - index pointing to first parameter
     * @return - updated instruction pointer
     */
    private int codeThree(int i) {
        intcode[intcode[i]] = input;
        return i+1;
    }

    /**
     * THis is the method that realises operation specified by instruction 4.
     * The method retrieves output from location specified in param1.
     * @param i - index pointing to first parameter
     * @return - updated instruction pointer
     */
    private int codeFour(int i) {
        int output = intcode[params[0].execute(i)];
        result.add(output);
        System.out.println("The output is: "+output);
        return i+1;
    }

    /**
     * This is the method that realises operation specified by instruction 5
     * The method jumps to location in param2 if param1 is not 0.
     * @param i - pointer pointing on param1
     * @return - pointer pointing new instruction, either specified in param2
     * or the next instruction in array
     */
    private int codeFive(int i) {
        //retrieve parameter values
        int a = intcode[params[0].execute(i)];
        int b = intcode[params[1].execute(i+1)];

        //determine result
        if (a!= 0) {
            return b;
        }
        return i+2;
    }

    /**
     * This is the method that realises operation specified by instruction 6.
     * The method jumps to location specified in param 2 if param1 is equal to 0.
     * @param i - pointer pointing the first parameter
     * @return - the pointer pointing the mext instruction opcode
     */
    private int codeSix(int i) {
        //retrieve parameter values
        int a = intcode[params[0].execute(i)];
        int b = intcode[params[1].execute(i+1)];

        //determine result
        if (a == 0) {
            return b;
        }
        else return i+2;
    }

    /**
     * This is the method that realises operation specified in instruction 7
     * The method stores in location specified by param3 0 if param1 is smaller than param3
     * and false otherwise.
     * @param i - pointer pointing param1
     * @return - instruction pointer pointing to the next instruction opcode
     */
    private int codeSeven(int i) {
        int a = intcode[params[0].execute(i)];
        int b = intcode[params[1].execute(i+1)];
        int c;
        if (a < b) {
            c = 1;
        } else {
            c = 0;
        }
        intcode[intcode[i+2]] = c;
        return i+3;
    }

    /**
     * This is the method that realises operation specified in instruction 8
     * The method stores in location specified by param3 0 if param1 is equal to param3
     * and false otherwise.
     * @param i - pointer pointing param1
     * @return - instruction pointer pointing to the next instruction opcode
     */
    private int codeEight(int i) {
        //retrieve the parameters
        int a = intcode[params[0].execute(i)];
        int b = intcode[params[1].execute(i+1)];
        int c;

        //determine the result
        if (a == b) {
            c = 1;
        } else {
            c = 0;
        }
        //store the result
        intcode[intcode[i+2]] = c;
        return i+3;
    }
}
