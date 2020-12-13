package year2020.day11;

import java.util.ArrayList;

/**
 * Represents a ferry.
 */
abstract class Ferry {
    ArrayList<ArrayList<Seat>> seats; //the map of seats, using enum Seat
    private int upperBound; //upper bound of the passengers tolerance in the amount of neighbours.

    /**
     * Creates ferry with the specified upper bound.
     * @param upperBound - upper bound of the passengers tolerance in the amount of neighbours.
     */
    Ferry(int upperBound) {
        seats = new ArrayList<>();
        this.upperBound = upperBound;
    }

    /**
     * Adds new rows of seats.
     * @param line = String of characters corresponding to values of Seat labels.
     */
    void addRow(String line) {
        ArrayList<Seat> seatRow = new ArrayList<>(line.length()); //new row to be added
        for (int i = 0; i < line.length(); i++) {
            //for each character, retrieve its value of Seat and add to the row ArrayList.
            Seat seat = Seat.getValue(line.charAt(i));
            seatRow.add(seat);
        }
        //add the full row to the seats map
        seats.add(seatRow);
    }

    /**
     * Adding round of passengers.
     * Every seat that doesn't neighbour any occupied seats before the round,
     * becomes occupied.
     */
    void addingRound() {
        ArrayList<Integer> rowValues = new ArrayList<>();
        ArrayList<Integer> colValues = new ArrayList<>();
        for (int i = 0; i < seats.size(); i++) { //rows
            for (int j = 0; j < seats.get(0).size(); j++) { //columns
                //for every sufficient seat, add it's coordinates to ArrayLists
                //to make it occupied after performing the check.
                int count = countNeighbours(i, j);
                if(seats.get(i).get(j)!=Seat.NULL && count==0){
                    rowValues.add(i);
                    colValues.add(j);
                }
            }
        }
        //for each saved coordinates, make the seat occupied.
        for (int i = 0; i< rowValues.size(); i++) {
            seats.get(rowValues.get(i)).set(colValues.get(i), Seat.OCCUPIED);
        }

    }

    /**
     * Removing round of passengers.
     * Every passenger that neighbours more than upperBound occupied seats, leaves.
     */
    void removingRound() {
        ArrayList<Integer> rowValues = new ArrayList<>();
        ArrayList<Integer> colValues = new ArrayList<>();
        for (int i = 0; i < seats.size(); i++) { //rows
            for (int j = 0; j < seats.get(0).size(); j++) { //columns
                //for each sufficient seat, adds it's coordinates
                int count = countNeighbours(i, j);
                if(seats.get(i).get(j)!=Seat.NULL && count>= upperBound){
                    rowValues.add(i);
                    colValues.add(j);
                }
            }
        }
        for (int i = 0; i< rowValues.size(); i++) {
            seats.get(rowValues.get(i)).set(colValues.get(i), Seat.EMPTY);
        }
    }

    int countSeats() {
        int result = 0;
        for (ArrayList<Seat> seat : seats) { //rows
            for (int j = 0; j < seats.get(0).size(); j++) {
                if (seat.get(j) == Seat.OCCUPIED) {
                    result++;
                }
            }
        }
        return result;
    }

    abstract int countNeighbours(int row, int col);

    boolean inBounds(int i, boolean isRow) {
        if (i< 0) {
            return false;
        }
        if (isRow) {
            return (i < seats.size());
        }
        return (i < seats.get(0).size());
    }

    String stringValue() {
        StringBuilder string = new StringBuilder();
        for (ArrayList<Seat> seat : seats) {
            for (int j = 0; j < seats.get(0).size(); j++) {
                string.append(Seat.valueOfElem(seat.get(j)));
            }
            string.append('\n');
        }
        return string.toString();
    }
}
