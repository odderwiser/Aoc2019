package day5.part1;

class Instruction {
    int opcode;
    Param[] params;
    Integer[] intcode;

    Instruction(Integer value, Integer[] intcode) {
        this.intcode = intcode;
        String val = value.toString();
        int length = val.length()-2;
        if(val.length()>1) {
            this.opcode = Integer.parseInt(val.substring(length));
        } else {
            this.opcode = value;
        }
        length--;
        if (opcode < 3) {
            params = new Param[2];
        } else {
            params = new Param[1];
        }
        for (int i = 0; i < params.length; i++) {
            if (length >= 0) {
                params[i] = new Param((val.charAt(length)-'0'));
                length--;
            } else {
                params[i] = new Param(0);
            }
        }
//        System.out.println("Opcode is "+val);
    }

    int execute(int i) {
            if (opcode==1) {
                i = codeOne(i);
            } else if (opcode==2) {
                i = codeTwo(i);
            } else if (opcode == 3) {
                i = codeThree(i);
            } else if (opcode == 4) {
                i = codeFour(i);
            } else if (opcode==99) {
                System.out.println("opcode 99");
                return intcode.length;
            } else{
                System.out.println("mistake");
            }

            return i;
    }

    private int codeOne(int i) {
        int a = intcode[params[0].execute(intcode, i)];
        int b = intcode[params[1].execute(intcode, i+1)];
        intcode[intcode[i+2]] =
                ((a+b));
//        System.out.println("The parameters are "+intcode[i]+", "+params[0].mode+" "+a+
//                "\n"+intcode[i+1]+", "+params[1].mode+" "+b+
//                "\n saved on position "+intcode[i+2]+": "+intcode[intcode[i + 2]]);
        return i+3;
    }

    private int codeTwo(int i) {
        intcode[intcode[i + 2]] =
                (intcode[params[0].execute(intcode, i)]
                        * intcode[params[1].execute(intcode, i+1)]);
//        System.out.println("The parameters are "+intcode[i]+", "+params[0].mode+" "+intcode[params[0].execute(intcode, i)]+
//                "\n"+intcode[i+1]+", "+params[1].mode+" "+intcode[params[1].execute(intcode, i+1)]+
//                "\n saved on position "+intcode[i+2]+": "+intcode[intcode[i + 2]]);
        return i+3;
    }

    private int codeThree(int i) {
        intcode[params[0].execute(intcode, i)] = 1;
        System.out.println("The parameters are "+intcode[i]);
        return i+1;
    }

    private int codeFour(int i) {
        int output = intcode[params[0].execute(intcode, i)];
        System.out.println("The output is: "+output+" on "+i);
        return i+1;
    }
}
