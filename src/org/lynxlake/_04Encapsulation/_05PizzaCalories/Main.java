// https://judge.softuni.bg/Contests/Practice/Index/221#4
package org.lynxlake._04Encapsulation._05PizzaCalories;

import org.lynxlake._04Encapsulation._05PizzaCalories.models.Dough;
import org.lynxlake._04Encapsulation._05PizzaCalories.models.Pizza;
import org.lynxlake._04Encapsulation._05PizzaCalories.models.Topping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader reader;

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                String[] input = reader.readLine().trim().split("\\s+");
                if (input[0].equalsIgnoreCase("END")) {
                    break;
                }

                String result = null;
                switch (input[0]) {
                    case "Dough":
                        Dough dough = tryMakeDough(input);
                        result = String.format("%.2f", dough.getCalories());
                        break;

                    case "Topping":
                        Topping topping = tryMakeTopping(input);
                        result = String.format("%.2f", topping.getCalories());
                        break;

                    case "Pizza":
                        Pizza pizza = tryMakePizza(input);
                        result = pizza.toString();
                        break;
                }

                System.out.println(result);
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Pizza tryMakePizza(String[] input) throws IOException {
        String name = input[1];
        int toppingCount = Integer.parseInt(input[2]);
        Pizza pizza = new Pizza(name, toppingCount);

        input = reader.readLine().trim().split("\\s+");
        Dough dough = tryMakeDough(input);
        pizza.setDough(dough);
        for (int i = 0; i < toppingCount; i++) {
            String[] toppingInput = reader.readLine().trim().split("\\s+");
            Topping topping = tryMakeTopping(toppingInput);
            pizza.addTopping(topping);
        }

        return pizza;
    }

    private static Topping tryMakeTopping(String[] input) {
        String type = input[1];
        int weight = Integer.parseInt(input[2]);

        return new Topping(type, weight);
    }

    private static Dough tryMakeDough(String[] input) {
        String flourType = input[1];
        String bakingTechnique = input[2];
        int weight = Integer.parseInt(input[3]);

        return new Dough(flourType, bakingTechnique, weight);
    }
}
