package year2019.day7;

import java.util.Optional;

public class ResultTuple {
    private Optional<Integer> value;
    private boolean finished;

    ResultTuple() {
        this.value = Optional.empty();
        finished = false;
    }

    public void set(Integer value) {
        this.value = Optional.of(value);
    }

    public int get() {
        return value.get();
    }

    public void done() {
        finished = true;
    }

    public boolean check() {
        return value.isPresent();
    }

    boolean isFinished() {
        return finished;
    }
}
