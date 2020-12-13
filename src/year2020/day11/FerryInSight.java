package year2020.day11;

public class FerryInSight extends Ferry {

    public FerryInSight() {
        super(5);
    }

    @Override
    int countNeighbours(int row, int col) {
        int[] rowValues = {-1, -1, -1, 0, 1, 1, 1, 0};
        int [] colValues = {-1, 0, 1, 1, 1, 0, -1, -1};
        int counter = 0;
        for (int i = 0; i< rowValues.length; i++) { //for every direction
            int newRow = row+rowValues[i];
            int newCol = col+colValues[i];
            while (inBounds(newRow, true) && inBounds(newCol, false)) {
                Seat seat = seats.get(newRow).get(newCol);
                if (seat.equals(Seat.OCCUPIED)) {
                    counter++;
                    break;
                } else if (seat.equals(Seat.EMPTY)) {
                    break;
                } else {
                    newRow+=rowValues[i];
                    newCol+=colValues[i];
                }
            }
        }
        return counter;
    }
}
