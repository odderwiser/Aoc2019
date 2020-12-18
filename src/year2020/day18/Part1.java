package year2020.day18;

import year2020.IntBox;
import year2020.Util;

import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) {
        Scanner scanner = Util.parseInput("resources/input18.txt");
        System.out.println(solve(scanner));
    }

    public static long solve(Scanner in) {
        long result = 0;
        while(in.hasNextLine()) {
            char[] arr = in.nextLine().replaceAll(" ", "").toCharArray();
            result+=sumArray(new IntBox(0), arr);
        }
        return result;
    }



    public static long sumArray(IntBox startIndex, char[] arr) {
        long sum;
        if (arr[startIndex.value]=='(') {
            startIndex.value++;
            sum = sumArray(startIndex, arr);
        } else {
            sum = arr[startIndex.value]- '0';
            startIndex.value++;
        }
        for (;startIndex.value < arr.length && arr[startIndex.value]!= ')'; startIndex.value+=2) {
            if (arr[startIndex.value]=='*') {
                if (arr[startIndex.value+1]=='(') {
                    startIndex.value+=2;
                    sum *= sumArray(startIndex, arr);
                    startIndex.value-=2;
                } else { sum*= (arr[startIndex.value+1] - '0'); }
            } else {
                if (arr[startIndex.value+1]=='(') {
                    startIndex.value +=2;
                    sum += sumArray(startIndex, arr);
                    startIndex.value-=2;
                } else { sum += (arr[startIndex.value + 1] - '0'); }
            }
        }
        startIndex.value++;
        return sum;
    }
}
