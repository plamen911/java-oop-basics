package org.lynxlake.creatingConstructors;

class Person {
    String name;
    int age;

    Person() {
        this("No name", 1);
    }

    Person(String name) {
        this(name, 1);
    }

    Person(int age) {
        this("No name", age);
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
