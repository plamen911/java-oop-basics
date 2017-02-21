package org.lynxlake._05Inheritance._04MordorsCrueltyPlan.factories;

import org.lynxlake._05Inheritance._04MordorsCrueltyPlan.models.Food;
import org.lynxlake._05Inheritance._04MordorsCrueltyPlan.models.food.*;

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
