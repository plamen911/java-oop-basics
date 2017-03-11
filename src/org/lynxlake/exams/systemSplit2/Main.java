package org.lynxlake.exams.systemSplit2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Plamen Markov on 3/10/17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TheSystem mySystem = new TheSystem();

        String line = "";
        while (!"System Split".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\(");
            String command = tokens[0];
            String[] commandArgs = tokens[1].substring(0, tokens[1].length() - 1).split(", ");

            switch (command) {
                case "RegisterPowerHardware":
                    mySystem.registerPowerHardware(commandArgs[0], Integer.parseInt(commandArgs[1]), Integer.parseInt(commandArgs[2]));
                    break;
                case "RegisterHeavyHardware":
                    mySystem.registerHeavyHardware(commandArgs[0], Integer.parseInt(commandArgs[1]), Integer.parseInt(commandArgs[2]));
                    break;
                case "RegisterExpressSoftware":
                    mySystem.registerExpressSoftware(commandArgs[0], commandArgs[1], Integer.parseInt(commandArgs[2]), Integer.parseInt(commandArgs[3]));
                    break;
                case "RegisterLightSoftware":
                    mySystem.registerLightSoftware(commandArgs[0], commandArgs[1], Integer.parseInt(commandArgs[2]), Integer.parseInt(commandArgs[3]));
                    break;
                case "ReleaseSoftwareComponent":
                    mySystem.releaseSoftwareComponent(commandArgs[0], commandArgs[1]);
                    break;
                case "Analyze":
                    System.out.println(mySystem.analyze());
                    break;
                case "Dump":
                    mySystem.Dump(commandArgs[0]);
                    break;
                case "Restore":
                    mySystem.Restore(commandArgs[0]);
                    break;
                case "Destroy":
                    mySystem.Destroy(commandArgs[0]);
                    break;
                case "DumpAnalyze":
                    System.out.println(mySystem.DumpAnalyze());;
                    break;
            }
        }

        System.out.println(mySystem.split());
    }
}
