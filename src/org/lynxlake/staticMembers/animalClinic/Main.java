// https://judge.softuni.bg/Contests/Practice/Index/231#4
package org.lynxlake.staticMembers.animalClinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine().trim();

        LinkedList<Animal> healedList = new LinkedList<>();
        LinkedList<Animal> rehabilitatedList = new LinkedList<>();

        while (!line.equalsIgnoreCase("End")) {
            String[] params = line.split("\\s+");

            String name = params[0];
            String breed = params[1];
            Animal animal = new Animal(name, breed);

            AnimalClinic.patientId++;

            switch (params[2]) {
                case "heal":
                    AnimalClinic.healedAnimalsCount++;
                    System.out.printf("Patient %d: [%s (%s)] has been healed!%n", AnimalClinic.patientId, name, breed);
                    healedList.add(animal);
                    break;

                case "rehabilitate":
                    AnimalClinic.rehabilitedAnimalsCount++;
                    System.out.printf("Patient %d: [%s (%s)] has been rehabilitated!%n", AnimalClinic.patientId, name, breed);
                    rehabilitatedList.add(animal);
                    break;
            }

            line = reader.readLine().trim();
        }
        System.out.printf("Total healed animals: %d%n", AnimalClinic.healedAnimalsCount);
        System.out.printf("Total rehabilitated animals: %d%n", AnimalClinic.rehabilitedAnimalsCount);

        line = reader.readLine().trim();
        reader.close();

        LinkedList<Animal> animals = new LinkedList<>();
        if (line.equalsIgnoreCase("heal")) {
            animals.addAll(healedList);
        } else {
            animals.addAll(rehabilitatedList);
        }
        for (int i = 0; i < animals.size(); i++) {
            System.out.printf("%s%n", animals.get(i));
        }
    }
}
