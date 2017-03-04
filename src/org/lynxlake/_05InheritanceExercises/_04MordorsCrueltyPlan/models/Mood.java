package org.lynxlake._05InheritanceExercises._04MordorsCrueltyPlan.models;

public abstract class Mood {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
