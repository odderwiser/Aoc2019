package year2020.day16;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class that represents the field on a ticket.
 */
public class Field {
    String name; //name of the field
    int[] bounds; // bounds within which a value could belong to this field: lower, upper, lower, upper
    HashSet<Integer> possibleFieldNums; // set of all possible field numbers

    /**
     * Field constructor
     * @param line - String in format as determined in the exercise.
     */
    Field(String line) {
        possibleFieldNums = new HashSet<>();
        String[] start = line.split(": |-| or ");
        this.name = start[0];
        bounds = new int[4];
        for (int i = 0; i < bounds.length; i++) {
            bounds[i] = Integer.parseInt(start[i+1]);
        }
    }

    void setPossibleFieldNums(int columnCount) {
        possibleFieldNums.addAll(IntStream.rangeClosed(0,columnCount-1)
                .boxed().collect(Collectors.toList()));
    }

    boolean isInRange(int number) {
        return ((number>= bounds[0] && number<= bounds[1]) ||
                (number>= bounds[2] && number<= bounds[3]));
    }

    boolean isDetermined() {
        return this.possibleFieldNums.size() ==1;
    }

    Integer[] outOfRange(Integer[] nums) {
        return Arrays.stream(nums).filter(x -> !isInRange(x)).toArray(Integer[]::new);
    }

    int verifyFieldNums(Integer[] nums) {
        possibleFieldNums.removeAll(possibleFieldNums.stream()
                .filter(x -> !isInRange(nums[x])).collect(Collectors.toList()));
        return possibleFieldNums.size();
    }

    void removeFieldNums(Ticket ticket) {
        for(Field field: ticket.getFields()) {
            if (!field.equals(this)&&field.isDetermined()) {
                this.possibleFieldNums.remove(field.possibleFieldNums.iterator().next());
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return name.equals(field.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public HashSet<Integer> getPossibleFieldNums() {
        return possibleFieldNums;
    }

    public String getName() {
        return name;
    }
}
