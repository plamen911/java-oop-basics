package org.lynxlake.exams.systemSplit2;

/**
 * Created by Plamen Markov on 3/10/17.
 */
public abstract class Component {
    private String name;
    private String type;
    private int capacity;
    private int memory;

    public Component(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getMemory() {
        return memory;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    protected void setMemory(int memory) {
        this.memory = memory;
    }
}
