// https://judge.softuni.bg/Contests/Practice/Index/231#7
package org.lynxlake._03StaticMembers._08ShapesVolume;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine().trim();
        while (!line.equalsIgnoreCase("End")) {
            String[] params = line.split("\\s+");
            double volume = 0.0;
            double height = 0.0;
            switch (params[0]) {
                case "TrianglePrism":
                case "TriangularPrism":
                    double baseSide = Double.parseDouble(params[1]);
                    height = Double.parseDouble(params[2]);
                    double length = Double.parseDouble(params[3]);
                    TriangularPrism triangularPrism = new TriangularPrism(baseSide, height, length);
                    volume = VolumeCalculator.getTriangularPrismVolume(triangularPrism);
                    System.out.printf("%.3f%n", volume);
                    break;

                case "Cube":
                    double sideLength = Double.parseDouble(params[1]);
                    Cube cube = new Cube(sideLength);
                    volume = VolumeCalculator.getCubeVolume(cube);
                    System.out.printf("%.3f%n", volume);
                    break;

                case "Cylinder":
                    double radius = Double.parseDouble(params[1]);
                    height = Double.parseDouble(params[2]);
                    Cylinder cylinder = new Cylinder(radius, height);
                    volume = VolumeCalculator.getCylinderVolume(cylinder);
                    System.out.printf("%.3f%n", volume);
                    break;
            }

            line = reader.readLine().trim();
        }
        reader.close();
    }
}
