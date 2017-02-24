// https://judge.softuni.bg/Contests/Practice/Index/221#3
package org.lynxlake._04EncapsulationExercises._04ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Person> people = new LinkedHashMap<>();
        LinkedHashMap<String, Product> products = new LinkedHashMap<>();
        LinkedList<String> shoppings = new LinkedList<>();

        try {
            // all people
            String[] pairs = reader.readLine().trim().split(";");
            if (pairs.length > 0) {
                for (String pair: pairs) {
                    if (pair != null && pair.trim().length() > 0) {
                        String[] params = pair.split("=");
                        String name = params[0];
                        double money = Double.parseDouble(params[1]);
                        if (!people.containsKey(name)) {
                            people.put(name, new Person(name, money));
                        }
                    }
                }
            }

            // all products
            pairs = reader.readLine().trim().split(";");
            if (pairs.length > 0) {
                for (String pair : pairs) {
                    if (pair != null && pair.trim().length() > 0) {
                        String[] params = pair.split("=");
                        String name = params[0];
                        double money = Double.parseDouble(params[1]);
                        if (!products.containsKey(name)) {
                            products.put(name, new Product(name, money));
                        }
                    }
                }
            }

            while (true) {
                pairs = reader.readLine().trim().split("\\s+");
                if (pairs[0].equalsIgnoreCase("END")) {
                    break;
                }

                String personName = pairs[0];
                String productName = pairs[1];

                if (people.containsKey(personName)) {
                    Person person = people.get(personName);
                    if (products.containsKey(productName)) {
                        Product product = products.get(productName);
                        try {
                            person.addProduct(product);
                            shoppings.add(String.format("%s bought %s", personName, productName));
                        } catch (IllegalArgumentException ex) {
                            shoppings.add(ex.getMessage());
                        }
                    }
                }
            }

            for (String shopping: shoppings) {
                System.out.println(shopping);
            }

            for (Person person: people.values()) {
                System.out.println(person.toString());
            }

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
