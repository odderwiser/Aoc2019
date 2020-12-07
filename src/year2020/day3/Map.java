package year2020.day3;

import java.util.ArrayList;
import java.util.Scanner;

public class Map {
    ArrayList<ArrayList<Integer>> map;
    int rowSize;
    int colSize;

    Map(Scanner scanner){
        map = new ArrayList<>();
        while (scanner.hasNextLine()) {
            addLine(scanner.nextLine());
        }
        rowSize = map.get(0).size();
        colSize = map.size();
    }

    void addLine(String line) {
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i< line.length(); i++) {
            if (line.charAt(i) < 40) {
                row.add(1);
            } else {row.add(0);}
        }
        map.add(row);
    }


    int jumpThrough(int horizontal, int vertical) {
        int currentHorizontal = 0;
        int currentVertical = 0;
        int result = 0;
        while (currentVertical < colSize-1) {
            currentVertical+=vertical;
            currentHorizontal = optimiseHorizontal(currentHorizontal+horizontal);
            if (map.get(currentVertical).get(currentHorizontal)==1) {
                result++;
                //map.get(currentVertical).remove(currentHorizontal);
                //map.get(currentVertical).add(currentHorizontal, 3);
            } else {
                //map.get(currentVertical).remove(currentHorizontal);
                //map.get(currentVertical).add(currentHorizontal, 2);
            }
        }
        return result;
    }

    int optimiseHorizontal(int horizontal) {
        if (horizontal>=rowSize) {
            horizontal = horizontal % (rowSize);
        }
        return horizontal;
    }

    void print() {
        for (int i = 0; i< map.size(); i++) {
            ArrayList<Integer> row = map.get(i);
            StringBuilder line = new StringBuilder();
            for (int j = 0; j<row.size(); j++ ) {
                line.append(row.get(j));
            }
            System.out.println(line.toString());
        }
    }
}
