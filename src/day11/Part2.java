package day11;

import intcode.ResultTuple;
import intcode.Util;

import java.util.Collections;
import java.util.LinkedList;

public class Part2 {

    public static void main(String[] args) {

        Util.initialise("resources/input11.txt");

        Robot robot = new Robot(Color.WHITE);
        ResultTuple result = new ResultTuple();
        while (!result.isFinished()) {
            //Input current color
            LinkedList<Long> input =
                    new LinkedList<>(Collections.singletonList(robot.getColor().toLong()));
            result = Util.solve(input);
            if (result.isFinished()) break;

            //Get new color
            Color newColor = Color.fromLong(result.get());
            robot.paint(newColor);

            //Get next direction
            result = Util.solve(input);
            robot.move(TurnDirection.fromLong(result.get()));
        }
        robot.map.print();
    }
}
