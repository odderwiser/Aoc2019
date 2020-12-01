package intcode;

import java.util.Arrays;
import java.util.LinkedList;

class Instruction {
    private int opcode;
    private intcode.Param[] params;
    long[] intcode;
    private intcode.ResultTuple result;
    private LinkedList<Long> input;
    private int[] sizes;
    private int relativeBase;
    private int updateValue = 0;
    /**
     * This is the method constructor.
     * @param value - long representing the opcode
     * @param intcode - array of all instructions
     * @param result - array that encapsulates reasult, if it is created
     * @param input - initialise value for instruction 3
     */
    Instruction(long value, long[] intcode, intcode.ResultTuple result,
                LinkedList<Long> input, int relativeBase) {
        this.result = result;
        this.intcode = intcode;
        this.input = input;
        this.sizes = intcode.Intcode.sizes;
        this.relativeBase = relativeBase;
        parseOpCode(value);
    }

    /**
     * This is the method to parse opcode and retrieve instruction details
     * @param value - the value of opcode
     */
    private void parseOpCode(long value) {
        //parse value of opcode to string
        String val = Long.toString(value);

        //retrieve the instruction number
        int length = val.length()-2;
        if(val.length()>1) {
            this.opcode = Integer.parseInt(val.substring(length));
        } else {
            this.opcode = ((int)  value);
        }
        length--;

        //determine the amount of parameters
        if (opcode < 10) {
            params = new intcode.Param[sizes[opcode]];
        } else {
            params = new intcode.Param[0];
        }

        //initialise parameters with proper modes
        for (int i = 0; i < params.length; i++) {
            if (length >= 0) {
                params[i] = new intcode.Param((val.charAt(length)-'0'), relativeBase, this);
                length--;
            } else {
                params[i] = new intcode.Param(0, relativeBase, this);
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
            case 9:
                i = codeNine(i);
                break;
            case 99:
                //end the program
                System.out.println("opcode 99");
                result.done();
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
        int index = get(params[0].execute(i));
        long a = intcode[index];
        long b = intcode[get(params[1].execute(i+1))];

        //store the value
        intcode[get(params[2].execute(i+2))] = (a + b);
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
        long a = intcode[get(params[0].execute(i))];
        long b = intcode[get(params[1].execute(i+1))];

        //store the results
        int address = get(params[2].execute(i+2));
        intcode[address] = (a * b);
        return i+3;
    }

    /**
     * THis is the method that realises operation specified by instruction 3.
     * The method stores input parameter in the value specified by param1.
     * @param i - index pointing to first parameter
     * @return - updated instruction pointer
     */
    private int codeThree(int i) {
        int index = get(params[0].execute(i));
        intcode[index] = input.pollFirst();
        System.out.println("input taken");
        return i+1;
    }

    /**
     * THis is the method that realises operation specified by instruction 4.
     * The method retrieves output from location specified in param1.
     * @param i - index pointing to first parameter
     * @return - updated instruction pointer
     */
    private int codeFour(int i) {
        int index = get(params[0].execute(i));
        long output = intcode[index];
        result.set(output);
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
        long a = intcode[get(params[0].execute(i))];
        long b = intcode[get(params[1].execute(i+1))];

        //determine result
        if (a!= 0) {
            return (int) b;
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
        long a = intcode[get(params[0].execute(i))];
        long b = intcode[get(params[1].execute(i+1))];

        //determine result
        if (a == 0) {
            return (int) b;
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
        long a = intcode[get(params[0].execute(i))];
        long b = intcode[get(params[1].execute(i+1))];
        int c;
        if (a < b) {
            c = 1;
        } else {
            c = 0;
        }
        int index = get(params[2].execute(i+2));
        intcode[index] = (long) c;
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
        long a = intcode[get(params[0].execute(i))];
        long b = intcode[get(params[1].execute(i+1))];
        int c;

        //determine the result
        if (a == b) {
            c = 1;
        } else {
            c = 0;
        }
        //store the result
        intcode[get(params[2].execute(i+2))] = (long) c;
        return i+3;
    }

    private int get(long index) {
        if (intcode.length <= index) {
            this.intcode = Arrays.copyOf(intcode, Math.max(2*intcode.length,((int) index+10)));
        }
        return ((int) index);
    }

    private int codeNine(int i) {
        this.updateValue = (int) intcode[get(params[0].execute(i))];
        return i+1;

    }

    public int getUpdateValue() {
        return this.updateValue;
    }

    public int getValue(int index) {
        int address = get(index);
        return (int) intcode[address];
    }
}
