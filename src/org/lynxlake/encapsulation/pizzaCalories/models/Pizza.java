package org.lynxlake.encapsulation.pizzaCalories.models;

import java.util.LinkedList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int toppingCount;

    public Pizza(String name, int toppingCount) {
        this.setName(name);
        this.setToppingCount(toppingCount);
        this.toppings = new LinkedList<>();
    }

    public double getTotalCalories() {
        double total = this.dough.getCalories();
        for (Topping topping : this.toppings) {
            total += topping.getCalories();
        }
        return total;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f Calories.", this.name, this.getTotalCalories());
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0 || name.trim().length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setToppingCount(int toppingCount) {
        if (toppingCount > 10 || toppingCount < 0) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppingCount = toppingCount;
    }
}
