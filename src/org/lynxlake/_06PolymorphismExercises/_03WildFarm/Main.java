// https://judge.softuni.bg/Contests/Practice/Index/242#2
package org.lynxlake._06PolymorphismExercises._03WildFarm;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String[] foodParams = scan.nextLine().split("\\s+");
            Food food = produceFood(foodParams);

            switch (data[0]) {
                case "Cat":
                    Cat cat = new Cat(data[1], Double.parseDouble(data[2]), data[3], data[4]);
                    cat.makeSound();
                    try {
                        cat.eat(food);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }

                    System.out.println(cat.toString());
                    break;

                case "Tiger":
                    Tiger tiger = new Tiger(data[1], Double.parseDouble(data[2]), data[3]);
                    tiger.makeSound();
                    try {
                        tiger.eat(food);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }

                    System.out.println(tiger.toString());
                    break;

                case "Zebra":
                    Zebra zebra = new Zebra(data[1], Double.parseDouble(data[2]), data[3]);
                    zebra.makeSound();
                    try {
                        zebra.eat(food);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }

                    System.out.println(zebra.toString());
                    break;

                case "Mouse":
                    Mouse mouse = new Mouse(data[1], Double.parseDouble(data[2]), data[3]);
                    mouse.makeSound();
                    try {
                        mouse.eat(food);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }

                    System.out.println(mouse.toString());
                    break;
            }

            input = scan.nextLine();
        }
    }

    private static Food produceFood(String[] foodParams) {
        Food food;

        if(foodParams[0].equals("Vegetable")) {
            food = new Vegetable(Integer.parseInt(foodParams[1]));
        } else {
            food = new Meat(Integer.parseInt(foodParams[1]));
        }

        return food;
    }
}

abstract class Food {
    private int quantity;

    public Food(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}

class Vegetable extends Food {

    public Vegetable(int quantity) {
        super(quantity);
    }
}

class Meat extends Food {

    public Meat(int quantity) {
        super(quantity);
    }
}

abstract class Animal {
    private String name;
    private double weight;
    private int foodEaten;

    public Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
        this.foodEaten = 0;
    }

    public int getFoodEaten() {
        return this.foodEaten;
    }

    public void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    public String getName() {
        return this.name;
    }

    public double getWeight() {
        return this.weight;
    }

    public abstract void makeSound();

    public abstract void eat(Food food);
}

abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String name, double weight) {
        super(name, weight);
    }

    public Mammal(String name, double weight, String livingRegion) {
        super(name, weight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }
}

abstract class Felime extends Mammal {

    public Felime(String name, double weight) {
        super(name, weight);
    }

    public Felime(String name, double weight, String livingRegion) {
        super(name, weight, livingRegion);
    }
}

class Cat extends Felime {
    private String breed;

    public Cat(String name, double weight, String livingRegion, String breed) {
        super(name, weight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("0.######");
        return String.format("%s[%s, %s, %s, %s, %d]",
                this.getClass().getSimpleName(), super.getName(), this.breed, format.format(super.getWeight()),
                super.getLivingRegion(), super.getFoodEaten());
    }
}

class Tiger extends Felime {
    public Tiger(String name, double weight, String livingRegion) {
        super(name, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Meat")) {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("0.######");
        return String.format("%s[%s, %s, %s, %d]",
                this.getClass().getSimpleName(), super.getName(), format.format(super.getWeight()),
                super.getLivingRegion(), super.getFoodEaten());
    }
}

class Mouse extends Mammal {

    public Mouse(String name, double weight, String livingRegion) {
        super(name, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")) {
            throw new IllegalArgumentException("Mouses are not eating that type of food!");
        }
        System.out.println("A cheese was just eaten!");
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("0.######");
        return String.format("%s[%s, %s, %s, %d]",
                this.getClass().getSimpleName(), super.getName(), format.format(super.getWeight()),
                super.getLivingRegion(), super.getFoodEaten());
    }
}

class Zebra extends Mammal {

    public Zebra(String name, double weight, String livingRegion) {
        super(name, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("0.######");
        return String.format("%s[%s, %s, %s, %d]",
                this.getClass().getSimpleName(), super.getName(), format.format(super.getWeight()),
                super.getLivingRegion(), super.getFoodEaten());
    }
}