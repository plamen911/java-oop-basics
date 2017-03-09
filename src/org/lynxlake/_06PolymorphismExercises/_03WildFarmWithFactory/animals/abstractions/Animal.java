package org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory.animals.abstractions;

import org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory.foods.Food;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;

    public Animal(String animalName, String animalType, double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
    }

    public abstract void makeSound();

    public abstract void eat(Food food);

    protected final String getAnimalType() {
        return animalType;
    }

    protected final String getAnimalName() {
        return animalName;
    }

    protected double getAnimalWeight() {
        return animalWeight;
    }

    protected final int getFoodEaten() {
        return this.foodEaten;
    }

    protected final void setFoodEaten(int foodEaten) {
        this.foodEaten += foodEaten;
    }
}
