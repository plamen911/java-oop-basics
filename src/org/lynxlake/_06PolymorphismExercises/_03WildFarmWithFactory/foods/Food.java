package org.lynxlake._06PolymorphismExercises._03WildFarmWithFactory.foods;

public abstract class Food {
    private int quantity;

    public Food(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
