package org.lynxlake._05Inheritance._04MordorsCrueltyPlan.models.food;

import org.lynxlake._05Inheritance._04MordorsCrueltyPlan.models.Food;

public class HoneyCake extends Food {
    private String name;
    private Integer pointOfHappiness;

    public HoneyCake(String name) {
        this.name = name;
        this.pointOfHappiness = 5;
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
