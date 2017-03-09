package org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory.animals.implementations;

import org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory.animals.abstractions.Mammal;

public class Zebra extends Mammal {

    public Zebra(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
