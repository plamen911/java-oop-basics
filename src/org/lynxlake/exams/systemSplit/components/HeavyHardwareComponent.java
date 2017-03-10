package org.lynxlake.exams.systemSplit.components;

public class HeavyHardwareComponent extends HardwareComponent {
    private static final String TYPE = "Heavy";

    public HeavyHardwareComponent(String name, int capacity, int memory) {
        super(name, TYPE);
        this.calculateCapacity(capacity);
        this.calculateMemory(memory);
    }

    @Override
    protected void calculateCapacity(int capacity) {
        super.setCapacity(capacity * 2);
    }

    @Override
    protected void calculateMemory(int memory) {
        super.setMemory(memory - ((int)(0.25 * memory)));
    }
}
