// https://judge.softuni.bg/Contests/Practice/Index/478#2
package org.lynxlake._05InheritanceLab._03HierarchicalInheritance;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.bark();

        Cat cat = new Cat();
        cat.eat();
        cat.meow();
    }
}
