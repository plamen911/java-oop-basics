package org.lynxlake.exams.systemSplit2;

/**
 * Created by Plamen Markov on 3/10/17.
 */
public class HeavyHardwareComponent extends HardwareComponent {
    private static final String TYPE = "Heavy";

    public HeavyHardwareComponent(String name, int capacity, int memory) {
        super(name, TYPE);
        this.setCapacity(capacity);
        this.setMemory(memory);
    }

    @Override
    protected void setCapacity(int capacity) {
        super.setCapacity(capacity * 2);
    }

    @Override
    protected void setMemory(int memory) {
        memory -= (int)(memory * 0.25);
        super.setMemory(memory);
    }
}
