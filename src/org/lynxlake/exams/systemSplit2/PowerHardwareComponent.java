package org.lynxlake.exams.systemSplit2;

/**
 * Created by Plamen Markov on 3/10/17.
 */
public class PowerHardwareComponent extends HardwareComponent {
    private static final String TYPE = "Power";

    public PowerHardwareComponent(String name, int capacity, int memory) {
        super(name, TYPE);
        this.setCapacity(capacity);
        this.setMemory(memory);
    }

    @Override
    protected void setCapacity(int capacity) {
        capacity -= (int)(0.75 * capacity);
        super.setCapacity(capacity);
    }

    @Override
    protected void setMemory(int memory) {
        memory += (int)(0.75 * memory);
        super.setMemory(memory);
    }
}
