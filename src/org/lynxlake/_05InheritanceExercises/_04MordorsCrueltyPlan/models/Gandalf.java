package org.lynxlake._05InheritanceExercises._04MordorsCrueltyPlan.models;

import org.lynxlake._05InheritanceExercises._04MordorsCrueltyPlan.factories.FoodFactory;
import org.lynxlake._05InheritanceExercises._04MordorsCrueltyPlan.factories.MoodFactory;

import java.util.ArrayList;

public class Gandalf {
    private Integer pointsOfHappiness;
    private ArrayList<Food> foods;
    private Mood mood;

    public Gandalf() {
        this.pointsOfHappiness = 0;
        this.foods = new ArrayList<>();
        this.setMood();
    }

    public Integer getPointsOfHappiness() {
        return this.pointsOfHappiness;
    }

    private void setHappinessPoin() {
        for (Food food : this.foods) {
            this.pointsOfHappiness += food.getPointOfHappiness();
        }
    }

    public void setMood() {
        this.mood = MoodFactory.getMood(this.pointsOfHappiness);
    }

    public void setFoods(String... foods) {
        for (String food : foods) {
            this.foods.add(FoodFactory.getFood(food));
        }
        if (foods.length >= 1) {
            setHappinessPoin();
        }
    }

    @Override
    public String toString() {
        return String.format("%d%n%s", this.pointsOfHappiness, this.mood);
    }
}
