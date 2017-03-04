package org.lynxlake._05InheritanceExercises._06Animals.models;

public class AnimalFactory {
    public static Animal getAnimal(String className, String animalName, int animalAge, String animalGender) {
        switch (className.toLowerCase()) {
            case "tomkat":
                return new Tomcat(animalName, animalAge, animalGender);
            case "kitten":
                return new Kitten(animalName, animalAge, animalGender);
            case "frog":
                return new Frog(animalName, animalAge, animalGender);
            case "dog":
                return new Dog(animalName, animalAge, animalGender);
            case "cat":
                return new Cat(animalName, animalAge, animalGender);
            default:
                return null;
        }
    }
}
