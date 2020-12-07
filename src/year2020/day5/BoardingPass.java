package year2020.day5;

public class BoardingPass {
    private int row;
    private int col;

    public BoardingPass(String seat){
        this.row = getValue(seat.substring(0,7),  'F');
        this.col = getValue(seat.substring(7), 'L');

    }

    private int getValue(String value, char condition) {
        int low = 0;
        int high = (int) Math.pow(2, value.length())-1;
        for (int i = 0; i < value.length()-1; i++) {
            if(value.charAt(i)==condition) {
                high = (low+high)/2;
            } else {
                low = (low+high+1)/2;
            }
        }
        if(value.charAt(value.length()-1)==condition) {
            return low;
        }
        return high;
    }

    int getSeatID() {
        return (row*8)+col;
    }

}
