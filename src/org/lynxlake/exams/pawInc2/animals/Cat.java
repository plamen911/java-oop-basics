package org.lynxlake.exams.pawInc2.animals;

import org.lynxlake.exams.pawInc2.centers.AdoptionCenter;

public class Cat extends Animal{
    private int intelligenceCoefficient;

    public Cat(String name, int age, int intelligenceCoefficient, AdoptionCenter a) {
        super(name, age, a);
        this.setIntelligenceCoefficient(intelligenceCoefficient);
    }

    public final int getIntelligenceCoefficient() {
        return this.intelligenceCoefficient;
    }

    private void setIntelligenceCoefficient(int intelligenceCoefficient) {
        this.intelligenceCoefficient = intelligenceCoefficient;
    }
}
