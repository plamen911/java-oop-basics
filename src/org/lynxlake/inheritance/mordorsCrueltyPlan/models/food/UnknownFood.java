package org.lynxlake.inheritance.mordorsCrueltyPlan.models.food;

import org.lynxlake.inheritance.mordorsCrueltyPlan.models.Food;

public class UnknownFood extends Food {
    private String name;
    private Integer pointOfHappiness;

    public UnknownFood(String name) {
        this.name = name;
        this.pointOfHappiness = -1;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getPointOfHappiness() {
        return this.pointOfHappiness;
    }
}
