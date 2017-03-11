package org.lynxlake.exams.systemSplit2;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Plamen Markov on 3/10/17.
 */
public class TheSystem {
    private Map<String, HardwareComponent> hardwareComponents;
    private Map<String, HardwareComponent> dumpComponents;

    public TheSystem() {
        this.hardwareComponents = new LinkedHashMap<>();
        this.dumpComponents = new LinkedHashMap<>();
    }

    public void registerPowerHardware(String name, int capacity, int memory) {
        PowerHardwareComponent hardwareComponent = new PowerHardwareComponent(name, capacity, memory);
        this.hardwareComponents.putIfAbsent(name, hardwareComponent);
    }

    public void registerHeavyHardware(String name, int capacity, int memory) {
        HeavyHardwareComponent hardwareComponent = new HeavyHardwareComponent(name, capacity, memory);
        this.hardwareComponents.putIfAbsent(name, hardwareComponent);
    }

    public void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            ExpressSoftwareComponent softwareComponent = new ExpressSoftwareComponent(name, capacity, memory);
            this.hardwareComponents.get(hardwareComponentName).registerSoftwareComponent(softwareComponent);
        }
    }

    public void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            LightSoftwareComponent softwareComponent = new LightSoftwareComponent(name, capacity, memory);
            this.hardwareComponents.get(hardwareComponentName).registerSoftwareComponent(softwareComponent);
        }
    }

    public void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName) {
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            this.hardwareComponents.get(hardwareComponentName).releaseSoftwareComponent(softwareComponentName);
        }
    }

    public String analyze() {
        return "System Analysis" +
                System.lineSeparator() +
                String.format("Hardware Components: %d", this.getHardwareComponentCount()) +
                System.lineSeparator() +
                String.format("Software Components: %d", this.getSoftwareComponentCount()) +
                System.lineSeparator() +
                String.format("Total Operational Memory: %d / %d", this.getTotalOperationalMemoryInUse(), this.getMaximumMemory()) +
                System.lineSeparator() +
                String.format("Total Capacity Taken: %d / %d", this.getTotalCapacityTaken(), this.getMaximumCapacity());
    }

    public String split() {

//        hardwareComponents.values().stream().sorted((c1, c2) -> {
//            if (c1.getType().equals("Power")) {
//                return -1;
//            }
//            return 1;
//        }).forEach(c -> {
//            StringBuilder sb = new StringBuilder();
//            sb.append(String.format("Hardware Component - %s\n", c.getName()));
//            sb.append(String.format("Express Software Components - %d\n", getSoftwareComponentsCount(c, "Express")));
//            sb.append(String.format("Light Software Components - %d\n", getSoftwareComponentsCount(c, "Light")));
//            sb.append(String.format("Memory Usage: %d / %d\n", c.getMemoryTaken(), c.getMemory()));
//            sb.append(String.format("Capacity Usage: %d / %d\n", c.getCapacityTaken(), c.getCapacity()));
//            sb.append(String.format("Type: %s\n", c.getType()));
//            sb.append(String.format("Software Components: %s", getSoftwareComponents(c)));
//
//            System.out.println(sb.toString());
//        });

        StringBuilder sb = new StringBuilder();

        this.hardwareComponents.entrySet().stream()
                .sorted((a1, a2) -> {
                    if (a1.getValue().getType().equals("Power")) {
                        return -1;
                    }
                    return 1;
                })
                .forEach(a -> {
                    long countOfExpressSoftwareComponents = a.getValue().getSoftwareComponents().values().stream()
                            .filter(b -> b.getType().equals("Express"))
                            .count();
                    long countOfLightSoftwareComponents = a.getValue().getSoftwareComponents().values().stream()
                            .filter(b -> b.getType().equals("Light"))
                            .count();

                    sb.append(String.format("Hardware Component - %s", a.getKey()))
                            .append(System.lineSeparator())
                            .append(String.format("Express Software Components - %d", countOfExpressSoftwareComponents))
                            .append(System.lineSeparator())
                            .append(String.format("Light Software Components - %d", countOfLightSoftwareComponents))
                            .append(System.lineSeparator())
                            .append(String.format("Memory Usage: %d / %d", a.getValue().getMemoryTaken(), a.getValue().getMemory()))
                            .append(System.lineSeparator())
                            .append(String.format("Capacity Usage: %d / %d", a.getValue().getCapacityTaken(), a.getValue().getCapacity()))
                            .append(System.lineSeparator())
                            .append(String.format("Type: %s", a.getValue().getType()))
                            .append(System.lineSeparator());
                    if (a.getValue().getSoftwareComponents().size() > 0) {
                        sb.append(String.format("Software Components: %s", String.join(", ", a.getValue().getSoftwareComponents().keySet())));
                    } else {
                        sb.append("Software Components: None");
                    }
                    sb.append(System.lineSeparator());
                });

        return sb.toString();
    }

    public void Dump(String hardwareComponentName) {
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            HardwareComponent hardwareComponent = this.hardwareComponents.get(hardwareComponentName);
            this.dumpComponents.putIfAbsent(hardwareComponentName, hardwareComponent);
            this.hardwareComponents.remove(hardwareComponentName);
        }
    }

    public void Restore(String hardwareComponentName) {
        if (this.dumpComponents.containsKey(hardwareComponentName)) {
            HardwareComponent hardwareComponent = this.dumpComponents.get(hardwareComponentName);
            this.hardwareComponents.putIfAbsent(hardwareComponentName, hardwareComponent);
            this.dumpComponents.remove(hardwareComponentName);
        }
    }

    public void Destroy(String hardwareComponentName) {
        if (this.dumpComponents.containsKey(hardwareComponentName)) {
            this.dumpComponents.remove(hardwareComponentName);
        }
    }

    public String DumpAnalyze() {
        long countOfPowerHardwareComponents = this.dumpComponents.entrySet().stream()
                .filter(a -> a.getValue().getType().equals("Power"))
                .count();
        long countOfHeavyHardwareComponents = this.dumpComponents.entrySet().stream()
                .filter(a -> a.getValue().getType().equals("Heavy"))
                .count();
        int[] count = {0};
        this.dumpComponents.values().forEach(a -> {
            count[0] += a.getSoftwareComponents().entrySet().stream()
                    .filter(e -> e.getValue().getType().equals("Express"))
                    .count();
        });
        int countOfExpressSoftwareComponents = count[0];

        count[0] = 0;
        this.dumpComponents.values().forEach(a -> {
            count[0] += a.getSoftwareComponents().entrySet().stream()
                    .filter(e -> e.getValue().getType().equals("Light"))
                    .count();
        });
        int countOfLightSoftwareComponents = count[0];

        int[] sum = {0};
        this.dumpComponents.values().forEach(a -> {
            sum[0] += a.getMemoryTaken();
        });
        int totalDumpedMemory = sum[0];

        sum[0] = 0;
        this.dumpComponents.values().forEach(a -> {
            sum[0] += a.getCapacityTaken();
        });
        int totalDumpedCapacity = sum[0];

        return "Dump Analysis" +
                System.lineSeparator() +
                String.format("Power Hardware Components: %d", countOfPowerHardwareComponents) +
                System.lineSeparator() +
                String.format("Heavy Hardware Components: %d", countOfHeavyHardwareComponents) +
                System.lineSeparator() +
                String.format("Express Software Components: %d", countOfExpressSoftwareComponents) +
                System.lineSeparator() +
                String.format("Light Software Components: %d", countOfLightSoftwareComponents) +
                System.lineSeparator() +
                String.format("Total Dumped Memory: %d", totalDumpedMemory) +
                System.lineSeparator() +
                String.format("Total Dumped Capacity: %d", totalDumpedCapacity);
//
//        System.out.println("Dump Analysis");
//        System.out.println("Power Hardware Components: " + countOfPowerHardwareComponents);
//        System.out.println("Heavy Hardware Components: " + countOfHeavyHardwareComponents);
//        System.out.println("Express Software Components: " + countOfExpressSoftwareComponents);
//        System.out.println("Light Software Components: " + countOfLightSoftwareComponents);
//        System.out.println("Total Dumped Memory: " + totalDumpedMemory);
//        System.out.println("Total Dumped Capacity: " + totalDumpedCapacity);
    }

    private int getHardwareComponentCount() {
        return this.hardwareComponents.size();
    }

    private int getSoftwareComponentCount() {
//        int[] count = {0};
//        this.hardwareComponents.values().forEach(a -> {
//            count[0] += a.getSoftwareComponents().values().size();
//        });
//
//        return count[0];

        return this.hardwareComponents.values().stream().mapToInt(h -> h.getSoftwareComponents().size()).sum();
    }

    private int getTotalOperationalMemoryInUse() {
//        int[] sum = {0};
//        this.hardwareComponents.values().forEach(a -> {
//            sum[0] += a.getMemoryTaken();
//        });
//
//        return sum[0];

        return this.hardwareComponents.values().stream().mapToInt(HardwareComponent::getMemoryTaken).sum();
    }

    private int getMaximumMemory() {
//        int[] sum = {0};
//        this.hardwareComponents.values().forEach(a -> {
//            sum[0] += a.getMemory();
//        });
//
//        return sum[0];

        return this.hardwareComponents.values().stream().mapToInt(HardwareComponent::getMemory).sum();
    }

    private int getTotalCapacityTaken() {
//        int[] sum = {0};
//        this.hardwareComponents.values().forEach(a -> {
//            sum[0] += a.getCapacityTaken();
//        });
//
//        return sum[0];

        return this.hardwareComponents.values().stream().mapToInt(HardwareComponent::getCapacityTaken).sum();
    }

    private int getMaximumCapacity() {
//        int[] sum = {0};
//        this.hardwareComponents.values().forEach(a -> {
//            sum[0] += a.getCapacity();
//        });
//
//        return sum[0];

        return this.hardwareComponents.values().stream().mapToInt(HardwareComponent::getCapacity).sum();
    }

    private int getSoftwareComponentsCount(HardwareComponent component, String componentType) {
        List<SoftwareComponent> components = component.getSoftwareComponents().values().stream()
                .filter(s -> s.getType().equals(componentType))
                .collect(Collectors.toList());

        return components.size();
    }

    private String getSoftwareComponents(HardwareComponent component) {
        if (component.getSoftwareComponents().size() == 0) {
            return "None";
        }
        List<String> componentsNames = component.getSoftwareComponents().values().stream()
                .map(Component::getName)
                .collect(Collectors.toList());

        return String.join(", ", componentsNames);
    }
}
