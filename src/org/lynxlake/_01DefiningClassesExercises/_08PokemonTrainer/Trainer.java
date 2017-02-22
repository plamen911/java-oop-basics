package org.lynxlake._01DefiningClassesExercises._08PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemons;   // collection of pokemon

    Trainer(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.badges = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void checkForElement(String element) {
        boolean hasElement = false;
        for (int i = 0; i < this.pokemons.size(); i++) {
            if (this.pokemons.get(i).getElement().equalsIgnoreCase(element)) {
                hasElement = true;
            }
        }

        if (hasElement) {
            this.badges++;
        } else {
            // all his pokemon lose 10 health
            for (int i = 0; i < this.pokemons.size(); i++) {
                // if a pokemon falls to 0 or less health he must be deleted from the collection
                int health = this.pokemons.get(i).getHealth();
                health -= 10;
                if (health <= 0) {
                    this.pokemons.remove(i);
                } else {
                    this.pokemons.get(i).setHealth(health);
                }
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badges, this.pokemons.size());
    }
}
