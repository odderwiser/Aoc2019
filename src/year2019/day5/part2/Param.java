package year2019.day5.part2;

class Param {
    private boolean mode;
    private Integer[] intcode;

    /**
     * This is Param constructor
     * @param mode - 0 if parameter mode, immediate mode otherwise
     * @param intcode - the array of instructions
     */
     Param(int mode, Integer[] intcode) {
        this.intcode = intcode;
        this.mode = (mode!=0);
    }

    /**
     * This is method to determine what index of paramter is retrueved, depending on mdoe
     * @param i - pointer to given parameter
     * @return - pointer to the value to be retrieved.
     */
    int execute(int i) {
        if (mode) {
            return i;
        }
        return intcode[i];
    }
}
