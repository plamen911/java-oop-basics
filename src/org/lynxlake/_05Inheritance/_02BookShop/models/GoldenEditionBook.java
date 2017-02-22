package org.lynxlake._05Inheritance._02BookShop.models;

public class GoldenEditionBook extends Book {
    public GoldenEditionBook(String author, String title, double price) {
        super(author, title, price);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + super.getPrice() * 0.3;
    }
}