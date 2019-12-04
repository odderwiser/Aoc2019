package day4;

import java.io.IOException;

public class SolutionPartOne {

    public static void main(String[] args) throws IOException {
        //define the lower and upper range of password
        String lower = "246515";
        String higher = "739105";

        //number of viable passwords
        int result = 0;
        lower = nextIncreasing(lower);


        //loop to process all values in given range
        while (Integer.parseInt(lower) < Integer.parseInt(higher)) {
            //loop to check if password is viable
            if (checkString(lower)) {
                result++;
            }

            //retrieve next non-decreasing value
            lower = nextIncreasing(lower);
        }

        //print results
        System.out.println(result);
        System.in.read();
    }

    /**
     * Method to check if String matches the password criterias:
     *  - non-decreasing
     *  - at least two edjacent numbers have the same value
     * @param lower - the string to be checked
     * @return - true if password is correct, false otherwise
     */
    private static boolean checkString(String lower) {
        //loop over all elements of the string
        for (int i = 0; i < (lower.length()-1); i++) {

            //if two edjacent characters are the same, return true
            if (lower.charAt(i+1) == lower.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieve the next non-decreasing value
     * @param lower - last String that was already verified
     * @return - next non-decreasing String
     */
    private static String nextIncreasing(String lower) {
        //increase the value of String by one
        Integer increase = Integer.parseInt(lower)+1;
        lower = increase.toString();

        //if string is not nondecreasing, make it so
        StringBuilder string = new StringBuilder(lower);
        for (int i = 0; i < (string.length()-1); i++) {
            if (string.charAt(i+1) < string.charAt(i)) {
                string.setCharAt((i+1), string.charAt(i));
            }
        }
        lower = string.toString();
        return lower;
    }

}
