package day2;

import java.util.Scanner;

public class Solution {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(Solution.class.getResourceAsStream("input2.txt"));
        String[] stringcode = scanner.nextLine().split(",");
        Integer[] intcode = new Integer[stringcode.length];
        for (int i = 0; i < intcode.length; i++) {
            intcode[i] = Integer.parseInt(stringcode[i]);
        }
        for (int i=0; i<= 99; i++) {
            for(int j = 0; j<= 99; j++) {
                Integer[] intcode2 = intcode.clone();
                intcode2[1]=i;
                intcode2[2]=j;
                for (int k=0; k< 3;k++) {
                    System.out.print(intcode2[k]+",");
                }
                int result=solve(intcode2);
                if (result==19690720) {
                    System.out.println((100*i+j));
                    break;
                }
            }
        }
    }

    public static int solve(Integer[] intcode){
        int i = 0;
        while (i < intcode.length) {
            int command = intcode[i];
            i++;
            if (command==1) {
                if ((i+2)<intcode.length) {
                    if (intcode[(i+2)]<intcode.length) {
                        intcode[intcode[i+2]] = codeOne(intcode, i);
                    }
                }
            } else if (command==2) {
                if (((i+2)<intcode.length)) {
                    if ((intcode[i+2]<intcode.length)) {
                        intcode[intcode[i+2]] = codeTwo(intcode, i);
                    }
                }
            } else if (command==99) {
                return intcode[0];
            } else{
                System.out.println("mistake");
            }
            i=i+3;
        }
        return intcode[0];
    }

    public static int codeOne(Integer[] intcode, int i) {
        return (intcode[intcode[i+1]]+intcode[intcode[i]]);
    }

    public static int codeTwo(Integer[] intcode, int i) {
         return (intcode[intcode[i+1]]* intcode[intcode[i]]);
    }
}
