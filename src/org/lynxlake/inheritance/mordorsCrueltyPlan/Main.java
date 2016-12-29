// https://judge.softuni.bg/Contests/Practice/Index/226#3
package org.lynxlake.inheritance.mordorsCrueltyPlan;

import org.lynxlake.inheritance.mordorsCrueltyPlan.models.Gandalf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] food = reader.readLine().split("\\s+");
        Gandalf gandalf = new Gandalf();
        gandalf.setFoods(food);
        gandalf.setMood();
        System.out.println(gandalf);
    }
}
