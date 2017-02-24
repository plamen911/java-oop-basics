package org.lynxlake._04EncapsulationExercises._03AnimalFarm.models;

public class Chicken {
    private int MIN_AGE = 0;
    private int MAX_AGE = 15;

    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getProductPerDay() {
        return this.calculateProductPerDay();
    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < this.MIN_AGE || age > this.MAX_AGE) {
            throw new IllegalArgumentException(String.format("Age should be between %d and %d.", this.MIN_AGE, this.MAX_AGE));
        }
        this.age = age;
    }

    private double calculateProductPerDay() {
        if (this.getAge() <= 6) {
            return 2.0;
        } else if (this.getAge() > 6 && this.getAge() <= 12) {
            return 1.0;
        } else {
            return 0.75;
        }
    }
}
