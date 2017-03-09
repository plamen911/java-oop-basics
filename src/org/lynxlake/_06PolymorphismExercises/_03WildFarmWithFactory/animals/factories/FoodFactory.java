package org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory.animals.factories;

import org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory.foods.Food;
import org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory.foods.Meat;
import org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory.foods.Vegetable;

public class FoodFactory {
    public Food getFood(String[] tokens) {
        String foodType = tokens[0];
        int quantity = Integer.parseInt(tokens[1]);

        switch (foodType.toLowerCase()) {
            case "vegetable":
                return new Vegetable(quantity);
            case "meat":
                return new Meat(quantity);
            default:
                return null;
        }
    }
}
