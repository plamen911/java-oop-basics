package org.lynxlake.inheritance.mordorsCrueltyPlan.factories;

import org.lynxlake.inheritance.mordorsCrueltyPlan.models.Food;
import org.lynxlake.inheritance.mordorsCrueltyPlan.models.food.*;

public class FoodFactory {
    public static Food getFood(String name) {
        String food = name.toLowerCase();
        switch (food) {
            case "cram":
                return new Cram(food);
            case "apple":
                return new Apple(food);
            case "lembas":
                return new Lembas(food);
            case "melon":
                return new Melon(food);
            case "honeycake":
                return new HoneyCake(food);
            case "mushrooms":
                return new Mushrooms(food);
            default:
                return new UnknownFood(food);

        }
    }
}
