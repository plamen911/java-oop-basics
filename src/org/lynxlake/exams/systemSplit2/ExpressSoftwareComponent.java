package org.lynxlake.exams.systemSplit2;

/**
 * Created by Plamen Markov on 3/10/17.
 */
public class ExpressSoftwareComponent extends SoftwareComponent {
    private static final String TYPE = "Express";

    public ExpressSoftwareComponent(String name, int capacity, int memory) {
        super(name, TYPE);
        this.setCapacity(capacity);
        this.setMemory(memory);
    }

    @Override
    protected void setMemory(int memory) {
        super.setMemory(memory * 2);
    }
}
