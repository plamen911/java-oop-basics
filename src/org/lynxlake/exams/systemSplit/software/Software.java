package org.lynxlake.exams.systemSplit.software;

import org.lynxlake.exams.systemSplit.Systems;

public abstract class Software extends Systems{
    private int capacityConsumption;
    private int memoryConsumption;

    Software(String name, String type, int capCon, int memCon) {
        super(name, type);
        this.setCapacityConsumption(capCon);
        this.setMemoryConsumption(memCon);
    }

    public final int getCapacityConsumption() {
        return this.capacityConsumption;
    }

    private void setCapacityConsumption(int capacityConsumption) {
        if (this.getType().equals("Light software")) {
            capacityConsumption += capacityConsumption / 2;
        }
        this.capacityConsumption = capacityConsumption;
    }

    public final int getMemoryConsumption() {
        return this.memoryConsumption;
    }

    private void setMemoryConsumption(int memoryConsumption) {
        if (this.getType().equals("Express software")) {
            memoryConsumption *= 2;
        } else {
            memoryConsumption -= memoryConsumption / 2;
        }
        this.memoryConsumption = memoryConsumption;
    }
}