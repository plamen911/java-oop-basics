// https://judge.softuni.bg/Contests/Practice/Index/230#7
package org.lynxlake._01DefiningClassesExercises._08PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Trainer> trainerList = new LinkedHashMap<>();
        List<Trainer> trainers = new ArrayList<>();

        String command = reader.readLine().trim();
        while (!command.equalsIgnoreCase("Tournament")) {
            String[] params = command.split("\\s+");
            String trainerName = params[0]; // unique
            String pokemonName = params[1];
            String pokemonElement = params[2];
            int pokemonHealth = Integer.valueOf(params[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if (!trainerList.containsKey(trainerName)) {
                Trainer trainer = new Trainer(trainerName);
                trainerList.put(trainerName, trainer);
                trainers.add(trainer);
            }
            trainerList.get(trainerName).setPokemons(pokemon);

            command = reader.readLine().trim();
        }

        command = reader.readLine().trim();
        while (!command.equalsIgnoreCase("End")) {
            for (int i = 0; i < trainers.size(); i++) {
                trainers.get(i).checkForElement(command);
            }
            command = reader.readLine().trim();
        }
        reader.close();

        Collections.sort(trainers, new Comparator<Trainer>() {
            @Override
            public int compare(Trainer o1, Trainer o2) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                return o1.getBadges() > o2.getBadges() ? -1 : (o1.getBadges() < o2.getBadges()) ? 1 : 0;
            }
        });

        // sort by amount of badges desc
        for (int i = 0; i < trainers.size(); i++) {
            System.out.println(trainers.get(i));
        }
    }
}
