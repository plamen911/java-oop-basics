package org.lynxlake._05InheritanceExercises._01Person;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < 3) {
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d",
                this.getName(),
                this.getAge());
    }

    private void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Age must be positive!");
        }
        this.age = age;
    }
}
