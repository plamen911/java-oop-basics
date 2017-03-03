package org.lynxlake._05InheritanceLab._04FragileBaseClass;

import java.util.ArrayList;
import java.util.Collections;

public class Animal {
    protected ArrayList<Food> foodEaten;

    public Animal() {
        this.foodEaten = new ArrayList<>();
    }

    public final void eat(Food food) {
        this.foodEaten.add(food);
    }

    public void eatAll(Food[] foods) {
        Collections.addAll(this.foodEaten, foods);
    }
}
