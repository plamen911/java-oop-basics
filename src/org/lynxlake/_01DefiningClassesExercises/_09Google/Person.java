package org.lynxlake._01DefiningClassesExercises._09Google;

import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;    // unique
    private Company company;
    private Car car;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;

    Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void addParent(Parent parent) {
        this.parents.add(parent);
    }

    public List<Child> getChildren() {
        return children;
    }

    public void addChild(Child child) {
        this.children.add(child);
    }
}
