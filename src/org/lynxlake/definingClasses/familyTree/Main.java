// https://judge.softuni.bg/Contests/Practice/Index/230#9
package org.lynxlake.definingClasses.familyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static HashMap<String, String> nameBirthdayMap;
    private static HashMap<String, String> birthdayNameMap;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String personInfo = reader.readLine().trim();   // Person's information

        nameBirthdayMap = new HashMap<>();
        birthdayNameMap = new HashMap<>();
        List<String> relationMap = new ArrayList<>();

        String line = reader.readLine().trim();
        while (!line.contains("End")) {
            if (line.contains(" - ")) {
                relationMap.add(line);
            } else {
                String[] params = line.split("\\s+");
                String firstName = params[0];
                String lastName = params[1];
                String birthday = params[2];
                nameBirthdayMap.put(firstName + " " + lastName, birthday);
                birthdayNameMap.put(birthday, firstName + " " + lastName);
            }
            line = reader.readLine().trim();
        }
        reader.close();

        String[] info;

        info = mapAndFormat(personInfo);
        String personName = info[0];
        String personBirthday = info[1];

        LinkedHashMap<String, String> parentMap = new LinkedHashMap<>();
        LinkedHashMap<String, String> childMap = new LinkedHashMap<>();
        for (int i = 0; i < relationMap.size(); i++) {
            String[] parts = relationMap.get(i).split("\\s+-\\s+");

            // the person on the left is parent to the person on the right
            info = mapAndFormat(parts[0]);
            if (!info[0].equalsIgnoreCase(personName) &&
                    (parts[1].equalsIgnoreCase(personName) || parts[1].equalsIgnoreCase(personBirthday)) &&
                    !parentMap.containsKey(info[0])) {
                parentMap.put(info[0], info[1]);
            }

            info = mapAndFormat(parts[1]);
            if (!info[0].equalsIgnoreCase(personName) &&
                    (parts[0].equalsIgnoreCase(personName) || parts[0].equalsIgnoreCase(personBirthday)) &&
                    !childMap.containsKey(info[0])) {
                childMap.put(info[0], info[1]);
            }
        }

        System.out.println(personName + " " + personBirthday);
        System.out.println("Parents:");
        for (Map.Entry<String, String> entry : parentMap.entrySet()) {
            System.out.printf("%s %s%n", entry.getKey(), entry.getValue());
        }
        System.out.println("Children:");
        for (Map.Entry<String, String> entry : childMap.entrySet()) {
            System.out.printf("%s %s%n", entry.getKey(), entry.getValue());
        }
    }

    private static String[] mapAndFormat(String entry) {
        String name;
        String birthday;
        if (isBirthday(entry)) {
            name = birthdayNameMap.get(entry);
            birthday = entry;
        } else {
            name = entry;
            birthday = nameBirthdayMap.get(entry);
        }

        return new String[] { name, birthday };
    }

    private static boolean isBirthday(String entry) {
        return !entry.contains(" ");
    }
}
