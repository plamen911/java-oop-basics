// https://judge.softuni.bg/Contests/Practice/Index/225#2
package org.lynxlake._02Methods._02OldestFamilyMember;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Family family = new Family();

        for (int i = 0; i < n; i++) {
            String[] params = reader.readLine().trim().split("\\s+");
            String name = params[0];
            int age = Integer.parseInt(params[1]);
            family.addFamilyMember(new Person(name, age));
        }

        reader.close();

        System.out.println(family.getOldestMember());

        Method getOldestMethod = Family.class.getMethod("getOldestMember");
        Method addMemberMethod = Family.class.getMethod("addFamilyMember", Person.class);
    }
}
