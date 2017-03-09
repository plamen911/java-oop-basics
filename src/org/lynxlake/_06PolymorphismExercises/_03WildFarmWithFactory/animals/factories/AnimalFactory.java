package org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory.animals.factories;

import org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory.animals.abstractions.Animal;
import org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory.animals.implementations.Cat;
import org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory.animals.implementations.Mouse;
import org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory.animals.implementations.Tiger;
import org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory.animals.implementations.Zebra;

public class AnimalFactory {

    public Animal getAnimal(String[] tokens) {
        String animalType = tokens[0];
        String animalName = tokens[1];
        double animalWeight = Double.parseDouble(tokens[2]);
        String livingRegion = tokens[3];

        switch (animalType.toLowerCase()) {
            case "cat":
                String catBreed = tokens[4];
                return new Cat(animalName, animalType, animalWeight, livingRegion, catBreed);

            case "mouse":
                return new Mouse(animalName, animalType, animalWeight, livingRegion);

            case "tiger":
                return new Tiger(animalName, animalType, animalWeight, livingRegion);

            case "zebra":
                return new Zebra(animalName, animalType, animalWeight, livingRegion);

            default:
                return null;
        }
    }

}
