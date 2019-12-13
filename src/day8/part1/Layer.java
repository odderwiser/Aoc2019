package day8.part1;

import java.util.HashMap;

public class Layer {
    HashMap<Character, Integer> digits;
    /*6*25*/
    int size;

    public Layer() {
        this.digits = new HashMap<>(3);
        digits.put('0',0);
        digits.put('1', 0);
        digits.put('2', 0);
        this.size = 6*25;
    }

    public void update(char c) {
        digits.replace(c, (digits.get(c)+1));
        this.size--;
    }

    public int get(char c) {
        return digits.get(c);
    }
}
