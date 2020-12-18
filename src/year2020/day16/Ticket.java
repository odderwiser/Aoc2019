package year2020.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Class that represents the set of fields.
 */
public class Ticket {
    private ArrayList<Field> fields;


    /**
     * Class constructor. Adds fields until an empty line in scanner.
     * @param scanner - scanner with fields in string format as per definition.
     */
    public Ticket(Scanner scanner) {
        fields = new ArrayList<>();
        //add fields until an empty line
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            }
            addField(line);
        }
    }

    /**
     * Check if all fields have determined values.
     * @return - true if all fields have determined values, else false.
     */
    public boolean areFieldsDetermined() {
        for (Field field: fields) {
            if (!field.isDetermined()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Get the list of fields in the ticket.
     * @return - ArrayList of Fields of the ticket.
     */
    public ArrayList<Field> getFields() {
        return fields;
    }

    /**
     * return the set of values that are invalid for all fields,
     * @param nums - array of values that each should fit to at least on field
     * @return - HashSet of values from the array that don't fit to any field.
     */
    HashSet<Integer> OutOfRange(Integer[] nums) {
        HashSet<Integer> unfit = new HashSet<>(Arrays.asList(nums));
        for (Field field: fields) {
            unfit.retainAll(Arrays.asList(field.outOfRange(nums)));
        }
        return unfit;
    }

    /**
     * Populate each field with all possible values it can take.
     * @param length - upper bound(exclusive) of the possible field values.
     */
    void setSizeOfFields(int length) {
        for(Field field: fields) {
            field.setPossibleFieldNums(length);
        }
    }

    /**
     * For an array of values, try to determine which indexes can't fit for a given field.
     * @param nums - array of values that each should fit at least one field.
     */
    void evaluateFields(Integer[] nums) {
        if (this.OutOfRange(nums).isEmpty()) {
            for (Field field: fields) {
                field.verifyFieldNums(nums);
            }
            removeFields();
        }
        areFieldsDetermined();
    }

    /**
     * Add a new field to the list of fields
     * @param line - field in string format as determined in aoc.
     */
    private void addField(String line) {
        fields.add(new Field(line));
    }

    /**
     * Recursive method. If any field has a determined index, remove that index from all other fields.
     * If that opearation at any point couses another field to become determined, restart the operation.
     */
    private void removeFields() {
        for (Field field: fields) {
            if (!field.isDetermined()) {
                field.removeFieldNums(this);
                if (field.isDetermined()) {
                    removeFields();
                }
            }
        }
    }

}
