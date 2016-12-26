package org.lynxlake.staticMembers.animalClinic;

class Animal {
    private String name;
    private String breed;

    public Animal(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.breed);
    }
}
