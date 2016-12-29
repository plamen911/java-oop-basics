package org.lynxlake.inheritance.mordorsCrueltyPlan.models.food;

import org.lynxlake.inheritance.mordorsCrueltyPlan.models.Food;

public class Cram extends Food {
    private String name;
    private Integer pointOfHappiness;

    public Cram(String name) {
        this.name = name;
        this.pointOfHappiness = 2;
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
