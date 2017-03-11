package org.lynxlake.exams.systemSplit2;

/**
 * Created by Plamen Markov on 3/10/17.
 */
public class LightSoftwareComponent extends SoftwareComponent {
    private static final String TYPE = "Light";

    public LightSoftwareComponent(String name, int capacity, int memory) {
        super(name, TYPE);
        this.setCapacity(capacity);
        this.setMemory(memory);
    }

    @Override
    protected void setCapacity(int capacity) {
        capacity += (int)(capacity * 0.5);
        super.setCapacity(capacity);
    }

    @Override
    protected void setMemory(int memory) {
        memory -= (int)(memory * 0.5);
        super.setMemory(memory);
    }
}
