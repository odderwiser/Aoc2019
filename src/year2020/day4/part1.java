package year2020.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class part1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner("dummyScannerObject");
        try {
            scanner = new Scanner(new File("resources/input04.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        String[] arr = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
        HashSet<String> keyValues = new HashSet<>(Arrays.asList(arr));
        HashSet<String> values = new HashSet<>();
        int result = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                if (values.size() == 7) {
                    result++;
                }
                values = new HashSet<>();
            } else {
                String[] keys = line.split(" ");
                for (int i = 0; i < keys.length; i++) {
                    String key = keys[i].split(":")[0];
                    if (keyValues.contains(key)) {
                        values.add(key);
                    }
                }
            }
        }
        System.out.println(result);
    }
}
