package org.lynxlake._04Encapsulation._04ShoppingSpree;

import java.util.LinkedList;
import java.util.List;

class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new LinkedList<>();
    }

    public void addProduct(Product product) {
        if (product.getCost() > this.money) {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));
        }
        this.money -= product.getCost();
        this.products.add(product);
    }

    @Override
    public String toString() {
        LinkedList<String> productNames = new LinkedList<>();
        for (Product product: this.products) {
            productNames.add(product.getName());
        }

        return String.format("%s - %s", this.name, ((productNames.size() == 0) ? "Nothing bought" : String.join(", ", productNames)));
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }
}
