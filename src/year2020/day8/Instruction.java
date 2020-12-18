package year2020.day8;


import year2020.IntBox;

import java.util.ArrayList;

public class Instruction {
    int value;
    String name;
    private boolean visited;
    Instruction next;
    ArrayList<Instruction> previous;
    boolean tail;

    Instruction(String name, int value) {
        visited = false;
        this.name = name;
        this.value = value;
        this.tail = false;
        this.previous = new ArrayList<>();
    }

    void setNext(Instruction next) {
        this.next = next;
        next.previous.add(this);
    }

    Instruction getNext() {
        return this.next;
    }

    ArrayList<Instruction> getPrevious() {
        return this.previous;
    }

    boolean hasPrevious() {
        return this.previous.size()>0;
    }

    boolean isVisited() {
        return visited;
    }

    boolean isJump() {
        return this.name.equals("jmp");
    }

    void unloop(){
        this.name = "nop";
    }

    void execute(IntBox counter, IntBox value) {
        //System.out.println(this.name+" "+this.value);
        this.visited=true;
        if (name.equals("nop")) {
            counter.value++;
        } else if (name.equals("acc")) {
            value.value+=this.value;
            counter.value++;
        } else if (name.equals("jmp")){
            counter.value+=this.value;
        }
    }
}
