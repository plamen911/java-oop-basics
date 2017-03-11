package org.lynxlake.exams.systemSplit2;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Plamen Markov on 3/10/17.
 */
public abstract class HardwareComponent extends Component {
    private int memoryTaken;
    private int capacityTaken;
    private Map<String, SoftwareComponent> softwareComponents;

    protected HardwareComponent(String name, String type) {
        super(name, type);
        this.softwareComponents = new LinkedHashMap<>();
    }

    public void registerSoftwareComponent(SoftwareComponent softwareComponent) {
        if (super.getMemory() - this.getMemoryTaken() >= softwareComponent.getMemory()
                && super.getCapacity() - this.getCapacityTaken() >= softwareComponent.getCapacity()) {

            this.softwareComponents.putIfAbsent(softwareComponent.getName(), softwareComponent);
            this.setCapacityTaken(this.getCapacityTaken() + softwareComponent.getCapacity());
            this.setMemoryTaken(this.getMemoryTaken() + softwareComponent.getMemory());
        }
    }

    public void releaseSoftwareComponent(String softwareComponentName) {
        if (this.softwareComponents.containsKey(softwareComponentName)) {
            SoftwareComponent softwareComponent = this.softwareComponents.get(softwareComponentName);
            this.setCapacityTaken(this.getCapacityTaken() - softwareComponent.getCapacity());
            this.setMemoryTaken(this.getMemoryTaken() - softwareComponent.getMemory());
            this.softwareComponents.remove(softwareComponentName);
        }
    }

    public int getMemoryTaken() {
        return memoryTaken;
    }

    public int getCapacityTaken() {
        return this.capacityTaken;
    }

    protected void setMemoryTaken(int memoryTaken) {
        this.memoryTaken = memoryTaken;
    }

    protected void setCapacityTaken(int capacityTaken) {
        this.capacityTaken = capacityTaken;
    }

    public Map<String, SoftwareComponent> getSoftwareComponents() {
        return Collections.unmodifiableMap(this.softwareComponents);
    }
}
