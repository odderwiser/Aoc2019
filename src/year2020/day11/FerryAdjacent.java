package year2020.day11;

public class FerryAdjacent extends Ferry {

    public FerryAdjacent(){
        super(4);
    }

    int countNeighbours(int row, int col) {
        int[] rowValues = {row-1, row-1, row-1, row, row+1, row+1, row+1, row};
        int [] colValues = {col-1, col, col+1, col+1, col+1, col, col-1, col-1};
        int counter = 0;
        for (int i = 0; i< rowValues.length; i++) {
            if (inBounds(rowValues[i], true) && inBounds(colValues[i], false)) {
                if (seats.get(rowValues[i]).get(colValues[i]).equals(Seat.OCCUPIED)) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
