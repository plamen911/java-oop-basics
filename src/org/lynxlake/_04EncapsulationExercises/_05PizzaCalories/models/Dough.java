package org.lynxlake._04EncapsulationExercises._05PizzaCalories.models;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private int weight;

    public Dough(String flourType, String bakingTechnique, int weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    public double getCalories() {
        return 2.0 * this.weight * this.getModifier(this.flourType) * this.getModifier(this.bakingTechnique);
    }

    private void setFlourType(String flourType) {
        if (!flourType.equalsIgnoreCase("white") && !flourType.equalsIgnoreCase("wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equalsIgnoreCase("crispy") &&
                !bakingTechnique.equalsIgnoreCase("chewy") &&
                !bakingTechnique.equalsIgnoreCase("homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(int weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private double getModifier(String type) {
        switch (type.toLowerCase()) {
            case "white":
                return 1.5;
            case "wholegrain":
                return 1.0;
            case "crispy":
                return 0.9;
            case "chewy":
                return 1.1;
            case "homemade":
                return 1.0;
            default:
                return 0.0;
        }
    }
}
