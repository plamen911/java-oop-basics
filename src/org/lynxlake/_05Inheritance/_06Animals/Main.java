// https://judge.softuni.bg/Contests/Practice/Index/226#5
package org.lynxlake._05Inheritance._06Animals;

import org.lynxlake._05Inheritance._06Animals.models.Animal;
import org.lynxlake._05Inheritance._06Animals.models.AnimalFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String className = reader.readLine().trim();
            if (className.equalsIgnoreCase("Beast!")) {
                break;
            }

            String[] params = reader.readLine().trim().split("\\s+");
            if (params[0].equalsIgnoreCase("Beast!")) {
                break;
            }

            String animalName = params[0];
            int animalAge = Integer.parseInt(params[1]);
            String animalGender = params[2];

            try {
                Animal animal = AnimalFactory.getAnimal(className, animalName, animalAge, animalGender);

                if (animal == null) {
                    throw new IllegalArgumentException("Invalid input!");
                }

                System.out.printf("%s%n%s %d %s%n", className, animalName, animalAge, animalGender);
                System.out.printf("%s%n", animal.produceSound());

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
