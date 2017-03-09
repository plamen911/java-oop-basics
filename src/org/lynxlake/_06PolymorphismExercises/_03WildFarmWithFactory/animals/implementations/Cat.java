package org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory.animals.implementations;

import org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory.animals.abstractions.Felime;
import org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory.foods.Food;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String catBreed;

    public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String catBreed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.setCatBreed(catBreed);
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        super.setFoodEaten(food.getQuantity());
    }

    public void setCatBreed(String catBreed) {
        this.catBreed = catBreed;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]",
                super.getAnimalType(),
                super.getAnimalName(),
                this.getCatBreed(),
                new DecimalFormat("#.################").format(super.getAnimalWeight()),
                this.getLivingRegion(),
                super.getFoodEaten()
        );
    }

    private String getCatBreed() {
        return this.catBreed;
    }
}
