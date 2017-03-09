package org.lynxlake.exams.systemSplit;


import org.lynxlake.exams.systemSplit.hardware.HeavyHardware;
import org.lynxlake.exams.systemSplit.hardware.PowerHardware;
import org.lynxlake.exams.systemSplit.software.ExpressSoftware;
import org.lynxlake.exams.systemSplit.software.LightSoftware;
import org.lynxlake.exams.systemSplit.hardware.Hardware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Hardware> hardware = new HashMap<>();
        HashMap<String, Hardware> dump = new HashMap<>();

        while (true) {
            String[] command = reader.readLine().split("\\(");
            if (command[0].equals("System Split")) break;
            String[] commandTokens = command[1].split(", ");
            switch (command[0]) {
                case "RegisterPowerHardware":
                    PowerHardware ph = new PowerHardware(commandTokens[0], "Power hardware", Integer.valueOf(commandTokens[1]),
                            Integer.valueOf(commandTokens[2].substring(0, commandTokens[2].length() - 1)));
                    hardware.put(commandTokens[0], ph);
                    break;
                case "RegisterHeavyHardware":
                    HeavyHardware hh = new HeavyHardware(commandTokens[0], "Heavy hardware", Integer.valueOf(commandTokens[1]),
                            Integer.valueOf(commandTokens[2].substring(0, commandTokens[2].length() - 1)));
                    hardware.put(commandTokens[0], hh);
                    break;
                case "RegisterLightSoftware":
                    LightSoftware ls = new LightSoftware(commandTokens[1], "Light software", Integer.valueOf(commandTokens[2]),
                            Integer.valueOf(commandTokens[3].substring(0, commandTokens[3].length() - 1)));
                    if (hardware.containsKey(commandTokens[0])) {
                        hardware.get(commandTokens[0]).tryAddSoftware(ls);
                    }
                    break;
                case "RegisterExpressSoftware":
                    ExpressSoftware es = new ExpressSoftware(commandTokens[1], "Express software", Integer.valueOf(commandTokens[2]),
                            Integer.valueOf(commandTokens[3].substring(0, commandTokens[3].length() - 1)));
                    if (hardware.containsKey(commandTokens[0])) {
                        hardware.get(commandTokens[0]).tryAddSoftware(es);
                    }
                    break;
                case "ReleaseSoftwareComponent":
                    if (hardware.containsKey(commandTokens[0])) {
                        hardware.get(commandTokens[0]).tryRemoveSoftware(hardware.get(commandTokens[0])
                                .getSoftware().get(commandTokens[1].substring(0, commandTokens[1].length()-1)).getName());
                    }
                    break;
                case "Analyze":
                    System.out.println("System Analysis");
                    System.out.println("hardware Components: " + hardware.size());
                    final int[] softwareCount = {0};
                    hardware.entrySet().forEach((key) -> softwareCount[0] += key.getValue().getSoftware().size());
                    System.out.println("software Components: " + softwareCount[0]);
                    final int[] totalOperationalMemoryUsed = {0};
                    final int[] totalOperationalMemoryCapacity = {0};
                    hardware.entrySet().forEach((key) -> {
                        totalOperationalMemoryCapacity[0] += key.getValue().getMaxMemory();
                        totalOperationalMemoryUsed[0] += key.getValue().getUsedMemory();
                    });
                    System.out.println("Total Operational Memory: " + totalOperationalMemoryUsed[0] + " / " + totalOperationalMemoryCapacity[0]);
                    final int[] totalOperationalCapacityUsed = {0};
                    final int[] totalOperationalCapacity = {0};
                    hardware.entrySet().forEach((key) -> {
                        totalOperationalCapacity[0] += key.getValue().getMaxCapacity();
                        totalOperationalCapacityUsed[0] += key.getValue().getUsedCapacity();
                    });
                    System.out.println("Total Capacity Taken: " + totalOperationalCapacityUsed[0] + " / " + totalOperationalCapacity[0]);
                    break;
                case "Dump":
                    String name = commandTokens[0].substring(0, commandTokens[0].length() - 1);
                    if (hardware.containsKey(name)) {
                        dump.put(name, hardware.get(name));
                        hardware.remove(name, hardware.get(name));
                    }
                    break;
                case "Restore":
                    String name1 = commandTokens[0].substring(0, commandTokens[0].length() - 1);
                    if (dump.containsKey(name1)) {
                        hardware.put(name1, dump.get(name1));
                        dump.remove(name1, dump.get(name1));
                    }
                    break;
                case "Destroy":
                    String name2 = commandTokens[0].substring(0, commandTokens[0].length() - 1);
                    if (dump.containsKey(name2)) {
                        dump.remove(name2, dump.get(name2));
                    }
                    break;
                case "DumpAnalyze":
                    long powerHardwareComponents = dump.entrySet().stream().filter(a -> a.getValue()
                            .getType().equals("Power hardware")).count();
                    System.out.println("Power hardware Components: " + powerHardwareComponents);
                    long heavyHardwareComponents = dump.entrySet().stream().filter(a -> a.getValue()
                            .getType().equals("Heavy hardware")).count();
                    System.out.println("Heavy hardware Components: " + heavyHardwareComponents);
                    final long[] expressSoftwareComponents = {0};
                    dump.entrySet().forEach(a -> expressSoftwareComponents[0] += a.getValue().getSoftware().entrySet().stream()
                            .filter(b -> b.getValue().getType().equals("Express software")).count());
                    System.out.println("Express software Components: " + expressSoftwareComponents[0]);
                    final long[] lightSoftwareComponents = {0};
                    dump.entrySet().forEach(a -> lightSoftwareComponents[0] += a.getValue().getSoftware().entrySet().stream()
                            .filter(b -> b.getValue().getType().equals("Light software")).count());
                    System.out.println("Light software Components: " + lightSoftwareComponents[0]);
                    final int[] totalDumpedMemory = {0};
                    dump.entrySet().forEach((key) -> {
                        totalDumpedMemory[0] += key.getValue().getUsedMemory();
                    });
                    System.out.println("Total Dumped Memory: " + totalDumpedMemory[0]);
                    final int[] totalDumpedCapacity = {0};
                    dump.entrySet().forEach((key) -> {
                        totalDumpedCapacity[0] += key.getValue().getUsedCapacity();
                    });
                    System.out.println("Total Dumped Capacity: " + totalDumpedCapacity[0]);
                default:
                    break;
            }
        }

        printHardware(hardware, "Power hardware");
        printHardware(hardware, "Heavy hardware");
    }

    private static void printHardware(HashMap<String, Hardware> hardwears, String hardwareType) {
        hardwears.entrySet().stream().filter(h -> h.getValue().getType().equals(hardwareType)).forEach(hard -> {
            System.out.println("hardware Component - " + hard.getKey());
            System.out.println("Express software Components - " + hard.getValue().getSoftware()
                    .entrySet().stream().filter(c -> c.getValue().getType().equals("Express software")).count());
            System.out.println("Light software Components - " + hard.getValue().getSoftware()
                    .entrySet().stream().filter(c -> c.getValue().getType().equals("Light software")).count());
            System.out.println("Memory Usage: " + hard.getValue().getUsedMemory() + " / " + hard.getValue().getMaxMemory());
            System.out.println("Capacity Usage: " + hard.getValue().getUsedCapacity() + " / " + hard.getValue().getMaxCapacity());
            System.out.println("Type: " + hard.getValue().getType().split("\\s+")[0]);
            ArrayList<String> list = new ArrayList<String>(hard.getValue().getSoftware().keySet());
            System.out.println("software Components: " + (list.isEmpty() ? "None" : list.toString().replace("]", "").replace("[", "")));
        });
    }
}