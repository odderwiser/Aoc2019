package year2019.intcode;

import java.util.LinkedList;

public class ResultTuple {
    LinkedList<Long> value;
    private boolean finished;

    public ResultTuple() {
        this.value = new LinkedList<>();
        finished = false;
    }

    public void set(Long value) {
        this.value.add(value);
    }

    public long get() {
        return value.getFirst();
    }

    public void done() {
        finished = true;
    }

    public boolean check() {
        return (value.size()>0);
    }

    public boolean isFinished() {
        return finished;
    }

    public long[] getArray() {
        return value.stream().mapToLong(i -> i).toArray();
    }
}
