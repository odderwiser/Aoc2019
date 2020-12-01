package day8.part1;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(Solution.class.getResourceAsStream("/2019/day8/input8.txt"));
        char[] input = scanner.nextLine().toCharArray();
        ArrayList<Layer> layers = parseInput(input);
        int index = getLayer(layers);
        System.out.println("result is: "+getValue(layers.get(index)));
    }

    public static ArrayList<Layer> parseInput(char[] digits) {
        ArrayList<Layer> input = new ArrayList<>();
        input.add(new Layer());
        int i = 0;

        for (char c : digits) {
            Layer layer = input.get(i);
            if (layer.size == 0) {
                i++;
                input.add(new Layer());
                layer = input.get(i);
            }
            layer.update(c);
        }

        return input;
    }

    public static int getLayer(ArrayList<Layer> layers) {
        int min = layers.get(0).get('0');
        int index = 0;
        for (int i = 0; i < layers.size(); i++) {
            if (layers.get(i).get('0') < min) {
                min  = layers.get(i).get('0');
                index = i;
            }
        }
        return index;
    }

    public static int getValue(Layer layer) {
        return (layer.get('1')*layer.get('2'));
    }
}
