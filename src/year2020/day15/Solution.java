package year2020.day15;

import year2020.Util;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Game game = new Game("12,20,0,6,1,17,7");
        //solution to part1
        System.out.println(game.playGame(2020));
        //solution to part2
        System.out.println(game.playGame(30000000));
    }

}
