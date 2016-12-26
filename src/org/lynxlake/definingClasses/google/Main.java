// https://judge.softuni.bg/Contests/Practice/Index/230#8
package org.lynxlake.definingClasses.google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Person> persons = new HashMap<>();

        String line = reader.readLine().trim();
        while (!line.equalsIgnoreCase("End")) {
            String[] params = line.split("\\s+");
            String name = params[0];

            Person person = null;
            if (!persons.containsKey(name)) {
                person = new Person(name);
                persons.put(name, person);
            }
            person = persons.get(name);

            switch (params[1]) {
                case "company":
                    String companyName = params[2];
                    String department = params[3];
                    double salary = Double.valueOf(params[4]);
                    Company company = new Company(companyName, department, salary);
                    person.setCompany(company);
                    break;

                case "car":
                    String carModel = params[2];
                    String carSpeed = params[3];
                    Car car = new Car(carModel, carSpeed);
                    person.setCar(car);
                    break;

                case "pokemon":
                    String pokemonName = params[2];
                    String pokemonType = params[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    person.addPokemon(pokemon);
                    break;

                case "parents":
                    String parentName = params[2];
                    String parentBirthday = params[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    person.addParent(parent);
                    break;

                case "children":
                    String childName = params[2];
                    String childBirthday = params[3];
                    Child child = new Child(childName, childBirthday);
                    person.addChild(child);
                    break;
            }

            line = reader.readLine().trim();
        }

        String personName = reader.readLine().trim();
        reader.close();

        if (persons.containsKey(personName)) {
            Person currentPerson = persons.get(personName);
            System.out.printf("%s%n", currentPerson.getName());
            System.out.println("Company:");
            if (currentPerson.getCompany() != null) {
                System.out.printf("%s %s %.2f%n",
                        currentPerson.getCompany().getCompanyName(),
                        currentPerson.getCompany().getDepartment(),
                        currentPerson.getCompany().getSalary());
            }
            System.out.println("Car:");
            if (currentPerson.getCar() != null) {
                System.out.printf("%s %s%n",
                        currentPerson.getCar().getCarModel(),
                        currentPerson.getCar().getCarSpeed());
            }

            System.out.printf("Pokemon:%n");
            for (int i = 0; i < currentPerson.getPokemons().size(); i++) {
                System.out.printf("%s %s%n",
                        currentPerson.getPokemons().get(i).getPokemonName(),
                        currentPerson.getPokemons().get(i).getPokemonType());
            }
            System.out.printf("Parents:%n");
            for (int i = 0; i < currentPerson.getParents().size(); i++) {
                System.out.printf("%s %s%n",
                        currentPerson.getParents().get(i).getParentName(),
                        currentPerson.getParents().get(i).getParentBirthday());
            }
            System.out.printf("Children:%n");
            for (int i = 0; i < currentPerson.getChildren().size(); i++) {
                System.out.printf("%s %s%n",
                        currentPerson.getChildren().get(i).getChildName(),
                        currentPerson.getChildren().get(i).getChildBirthday());
            }
        } else {
            System.out.println("Not found ;-(");
        }

    }
}
