package year2020.day18;

import year2020.IntBox;
import year2020.Util;

import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) {
        Scanner scanner = Util.parseInput("resources/input18.txt");
        System.out.println(solve(scanner));
    }

    public static long solve(Scanner in) {
        long result = 0;
        while(in.hasNextLine()) {
            String operation = in.nextLine().replaceAll(" ", "");
            result+=Long.parseLong(parseOperation(operation));
        }
        return result;
    }

    static String parseOperation(String operation) {
        while(operation.contains("(")) {
            int start = findInnermostBracket(operation);
            int end = operation.indexOf(")", start);
            operation = operation.replace(operation.substring(start, end+1),
                    parseOperation(operation.substring(start+1, end)));
        }
        while (operation.contains("+")) {
            int i = operation.indexOf("+");
            int start = startIndex(operation, i-1);
            int end = endIndex(operation, i+1);
            operation = operation.replace(operation.substring(start, end+1),
                    Long.toString(Long.parseLong(operation.substring(start, i))
                            + Long.parseLong(operation.substring(i+1, end+1))));
        }
        while (operation.contains("*")) {
            int i = operation.indexOf("*");
            int start = startIndex(operation, i-1);
            int end = endIndex(operation, i+1);
            operation = operation.replace(operation.substring(start, end+1),
                    Long.toString(Long.parseLong(operation.substring(start, i))
                            * Long.parseLong(operation.substring(i+1, end+1))));
        }
        return operation;

    }

    static int startIndex(String operation, int start) {
        while (start>0 &&Character.isDigit(operation.charAt(start))) {
            start--;
        }
        if (!Character.isDigit(operation.charAt(start))) {
            start++;
        }
        return start;
    }

    static int endIndex(String operation, int end) {
        while (end < operation.length()-1 && Character.isDigit(operation.charAt(end))) {
            end++;
        }
        if (!Character.isDigit(operation.charAt(end))) {
            end--;
        }
        return end;
    }



    static int findInnermostBracket(String operation) {
        int i = operation.indexOf(")");
        while (operation.charAt(i)!='(') {
            i--;
        }
        return i;
    }
}
