package year2020.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class Part2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner("dummyScannerObject");
        try {
            scanner = new Scanner(new File("resources/input04.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        String[] arr = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
        HashSet<String> keyValues = new HashSet<>(Arrays.asList(arr));
        HashMap<String, String> document = new HashMap<>();
        int result = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                if (document.size() == 7) {
                    boolean valid = validateYear(document.get("byr"), 1920, 2002);
                    valid = (valid && validateYear(document.get("iyr"), 2010, 2020));
                    valid = (valid && validateYear(document.get("eyr"), 2020, 2030));
                    valid = (valid && validateHeight(document.get("hgt")));
                    valid = (valid && validateHcl(document.get("hcl")));
                    valid = (valid && validateEcl(document.get("ecl")));
                    valid = (valid && validatePid(document.get("pid")));
                    if (valid) {
                        result++;
                    }
                }
                document = new HashMap<>();
            } else {
                String[] keys = line.split(" ");
                for (int i = 0; i < keys.length; i++) {
                    String[] key = keys[i].split(":");
                    if (keyValues.contains(key[0])) {
                        document.put(key[0], key[1]);
                    }
                }
            }
        }
        if (document.size() == 7) {
            boolean valid = validateYear(document.get("byr"), 1920, 2020);
            valid = (valid && validateYear(document.get("iyr"), 2010, 2020));
            valid = (valid && validateYear(document.get("eyr"), 2020, 2030));
            valid = (valid && validateHeight(document.get("hgt")));
            valid = (valid && validateHcl(document.get("hcl")));
            valid = (valid && validateEcl(document.get("ecl")));
            valid = (valid && validatePid(document.get("pid")));
            if (valid) {
                result++;
                System.out.println("Number: " + result);
                for (String key : document.keySet()) {
                    System.out.println(key + ": " + document.get(key));
                }
            }
        }
        System.out.println(result);
    }

    static boolean validateYear(String byr, int lowerBound, int upperBound) {
        Pattern pattern = Pattern.compile("^\\d+$");
        if (byr.length()==4 && pattern.matcher(byr).matches()) {
            int value = Integer.parseInt(byr);
            return (value>= lowerBound && value <=upperBound);
        }
        return false;
    }

    static boolean validateHeight(String hgt) {
        String numeric = hgt.substring(0, hgt.length()-2);
        String unit = hgt.substring(hgt.length()-2);
        if (!unit.equals("in")&& (!unit.equals("cm"))){
            return false;
        }
        Pattern pattern = Pattern.compile("^\\d+$");
        if (!pattern.matcher(numeric).matches()){
            return false;
        }
        int number = Integer.parseInt(numeric);
        if ((unit.equals("in") && number >=59 && number <= 76) ||
                (unit.equals("cm") && number >= 150 && number <= 193)) {
            return true;
        }
        return false;
    }

    static boolean validateHcl(String hcl) {
        if (hcl.length() != 7 || hcl.charAt(0)!= '#'){
            return false;
        }
        Pattern pattern = Pattern.compile("^[0-9a-f]+$");
        return pattern.matcher(hcl.substring(1)).matches();
    }

    static boolean validateEcl(String ecl){
        String[] allowed = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
        return Arrays.asList(allowed).contains(ecl);
    }

    static boolean validatePid(String pid) {
        Pattern pattern = Pattern.compile("^\\d+$");
        return (pid.length()==9 && pattern.matcher(pid).matches());
    }

}
