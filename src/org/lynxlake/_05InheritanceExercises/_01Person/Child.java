package org.lynxlake._05InheritanceExercises._01Person;

class Child extends Person {
    public Child(String name, int age) {
        super(name, age);
        this.setAge(age);
    }

    protected void setAge(int age) {
        if (age > 15) {
            throw new IllegalArgumentException("Child's age must be lesser than 15!");
        }
    }
}
