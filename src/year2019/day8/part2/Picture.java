package year2019.day8.part2;

public class Picture {
    Pixel[][] array;
    int vertIndex;
    int horIndex;

    public Picture() {
        array = new Pixel[6][25];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = new Pixel();
            }
        }
        this.vertIndex = 0;
        this.horIndex = 0;
    }

    public void putPixel(char c) {
        array[horIndex][vertIndex].setValue(c);
        vertIndex++;
        changeRow();
    }

    private void changeRow() {
        if (vertIndex > 24) {
            vertIndex = 0;
            horIndex++;
            if (horIndex > 5) {
                horIndex = 0;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result.append(array[i][j].get());
            }
            result.append("\n");
        }
        return result.toString();
    }
}
