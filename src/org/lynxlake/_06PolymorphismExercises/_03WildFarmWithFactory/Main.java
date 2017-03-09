package org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory;

import org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory.animals.abstractions.Animal;
import org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory.animals.factories.AnimalFactory;
import org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory.animals.factories.FoodFactory;
import org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory.foods.Food;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AnimalFactory animalFactory = new AnimalFactory();
        FoodFactory foodFactory = new FoodFactory();
        String line = "";

        while (!"End".equals(line = reader.readLine())) {
            String[] animalTokens = line.split("\\s+");
            Animal animal = animalFactory.getAnimal(animalTokens);

            String[] foodTokens = reader.readLine().split("\\s+");
            Food food = foodFactory.getFood(foodTokens);

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println(animal);
        }
    }
}
