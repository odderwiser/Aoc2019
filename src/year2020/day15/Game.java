package year2020.day15;

import java.util.Arrays;
import java.util.HashMap;

public class Game {
    HashMap<Integer, Integer> rounds;
    int lastRound;
    int lastValue;

    public Game(String line) {
        this(Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray());
    }

    public Game(int[] array) {
        this.rounds = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            rounds.put(value, i+1);
            if (i+1 == array.length) {
                this.lastRound = i+1;
                this.lastValue = value;
            }
        }
    }

    public int playGame(int finalRound) {
        while (this.lastRound < finalRound) {
            playRound();
        }
        return lastValue;
    }

    public void playRound() {
        int newValue;
        if (rounds.containsKey(lastValue)) {
            newValue = lastRound-rounds.get(lastValue);
        } else {
           newValue = 0;
        }
        rounds.put(lastValue, lastRound);
        lastRound++;
        lastValue = newValue;
    }

}
