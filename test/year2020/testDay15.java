package year2020;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import year2020.day15.Game;

import java.util.Scanner;

public class testDay15 {


    @Test
    public void testPart1_a() {
        Game game = new Game(new int[]{0,3,6});
        Assertions.assertEquals(436, game.playGame(2020));
    }

    @Test
    public void testPart1_b() {
        Game game = new Game(new int[]{1,3,2});
        Assertions.assertEquals(1, game.playGame(2020));
    }
}
