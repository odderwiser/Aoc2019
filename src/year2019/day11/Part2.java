package year2019.day11;

import year2019.intcode.ResultTuple;
import year2019.intcode.Intcode;

import java.util.Collections;
import java.util.LinkedList;

public class Part2 {

    public static void main(String[] args) {

        Intcode intcode  = new Intcode("resources/input11.txt");

        Robot robot = new Robot(Color.WHITE);
        ResultTuple result = new ResultTuple();
        while (!result.isFinished()) {
            //Input current color
            LinkedList<Long> input =
                    new LinkedList<>(Collections.singletonList(robot.getColor().toLong()));
            result = intcode.solve(input);
            if (result.isFinished()) break;

            //Get new color
            Color newColor = Color.fromLong(result.get());
            robot.paint(newColor);

            //Get next direction
            result = intcode.solve(input);
            robot.move(TurnDirection.fromLong(result.get()));
        }
        robot.map.print();
    }
}
