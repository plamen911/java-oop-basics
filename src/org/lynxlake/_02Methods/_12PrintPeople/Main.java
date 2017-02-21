// https://judge.softuni.bg/Contests/Practice/Index/225#12
package org.lynxlake._02Methods._12PrintPeople;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        String line = reader.readLine().trim();
        while (!line.equalsIgnoreCase("END")) {
            String[] params = line.split("\\s+");
            String name = params[0];
            int age = Integer.parseInt(params[1]);
            String occupation = params[2];

            Person person = new Person(name, age, occupation);
            people.add(person);

            line = reader.readLine().trim();
        }

        Collections.sort(people);

        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i));
        }

        reader.close();
    }
}
