package intcode;

class Param {
    private int mode;
    private int relativeBase;
    private Instruction mother;

    /**
     * This is Param constructor
     * @param mode - 0 if parameter mode, immediate mode otherwise
     */
     Param(int mode, int relativeBase, Instruction mother) {
        this.mode = mode;
        this.relativeBase = relativeBase;
        this.mother = mother;
     }

    /**
     * This is method to determine what index of paramter is retrueved, depending on mdoe
     * @param i - pointer to given parameter
     * @return - pointer to the value to be retrieved.
     */
    long execute(int i) {
        if (mode==1) {
            return i;
        } else if (mode == 2) {
            int value = mother.getValue(i)+relativeBase;
            return value;
        }
        return mother.getValue(i);
    }
}
