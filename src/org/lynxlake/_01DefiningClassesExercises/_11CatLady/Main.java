// https://judge.softuni.bg/Contests/Practice/Index/230#10
package org.lynxlake._01DefiningClassesExercises._11CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Cat> cats = new HashMap<>();

        String line = reader.readLine();
        while (!line.equalsIgnoreCase("End")) {
            String[] params = line.split("\\s+");
            String breed = params[0];
            String name = params[1];
            int characteristics = Integer.valueOf(params[2]);
            Cat cat = null;

            switch (breed) {
                case "Siamese":
                    cat = new Siamese(name, characteristics);
                    break;

                case "Cymric":
                    cat = new Cymric(name, characteristics);
                    break;

                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(name, characteristics);
                    break;
            }
            if (!cats.containsKey(name)) {
                cats.put(name, cat);
            }

            line = reader.readLine();
        }

       /* HashMap<String, String> cats = new HashMap<>();

        String line = reader.readLine();
        while (!line.equalsIgnoreCase("End")) {
            String[] params = line.split("\\s+");
            // String breed = params[0];
            String name = params[1];
            // String characteristics = params[2];

            if (!cats.containsKey(name)) {
                cats.put(name, line);
            }

            line = reader.readLine();
        }*/

        String petName = reader.readLine();
        if (cats.containsKey(petName)) {
            System.out.println(cats.get(petName));
        } else {
            System.out.println(";(");
        }
    }
}
