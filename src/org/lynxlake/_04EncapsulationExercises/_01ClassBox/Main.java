// https://judge.softuni.bg/Contests/Practice/Index/221#0
package org.lynxlake._04EncapsulationExercises._01ClassBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double length = Double.parseDouble(reader.readLine());
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());

        Class boxClass = Box.class;
        Field[] fields = boxClass.getDeclaredFields();
//        System.out.println(Arrays.asList(fields)
//                .stream()
//                .filter(f -> Modifier.isPrivate(f.getModifiers())).count());

        Box box = new Box(length, width, height);
        System.out.printf("Surface Area - %.2f%n", box.getSurfaceArea());
        System.out.printf("Lateral Surface Area - %.2f%n", box.getLateralSurfaceArea());
        System.out.printf("Volume - %.2f%n", box.getVolume());
    }
}
