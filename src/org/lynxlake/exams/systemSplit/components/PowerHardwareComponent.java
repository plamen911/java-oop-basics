package org.lynxlake.exams.systemSplit.components;

public class PowerHardwareComponent extends HardwareComponent {
    private static final String TYPE = "Power";

    public PowerHardwareComponent(String name, int capacity, int memory) {
        super(name, TYPE);
        this.calculateCapacity(capacity);
        this.calculateMemory(memory);
    }


    @Override
    protected void calculateMemory(int memory) {
        super.setMemory(memory + ((int)(0.75 * memory)));
    }

    @Override
    protected void calculateCapacity(int capacity) {
        super.setCapacity(capacity - ((int)(0.75 * capacity)));
    }
}
