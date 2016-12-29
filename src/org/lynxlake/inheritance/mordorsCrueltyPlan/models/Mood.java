package org.lynxlake.inheritance.mordorsCrueltyPlan.models;

public abstract class Mood {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
