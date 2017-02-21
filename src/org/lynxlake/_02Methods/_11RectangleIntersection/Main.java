// https://judge.softuni.bg/Contests/Practice/Index/225#11
package org.lynxlake._02Methods._11RectangleIntersection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] params = reader.readLine().trim().split("\\s+");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);

        HashMap<String, Rectangle> rectangles = new HashMap<>();

        for (int i = 0; i < n; i++) {
            params = reader.readLine().trim().split("\\s+");
            String id = params[0];
            int width = Integer.parseInt(params[1]);
            int height = Integer.parseInt(params[2]);
            int topLeftX = Integer.parseInt(params[3]);
            int topLeftY = Integer.parseInt(params[4]);

            if (!rectangles.containsKey(id)) {
                Rectangle rectangle = new Rectangle(id, width, height, topLeftX, topLeftY);
                rectangles.put(id, rectangle);
            }
        }

        for (int i = 0; i < m; i++) {
            String[] pairs = reader.readLine().trim().split("\\s+");
            if (rectangles.containsKey(pairs[0]) && rectangles.containsKey(pairs[1])) {
                System.out.printf("%b%n", rectangles.get(pairs[0]).hasIntersection(rectangles.get(pairs[1])));
            }
        }

        reader.close();
    }
}
