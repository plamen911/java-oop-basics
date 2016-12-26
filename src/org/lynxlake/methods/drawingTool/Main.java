// https://judge.softuni.bg/Contests/Practice/Index/225#1
package org.lynxlake.methods.drawingTool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException, NullPointerException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String figureType = reader.readLine();
        Figure figure = null;
        switch (figureType) {
            case "Rectangle":
                int width = Integer.parseInt(reader.readLine());
                int height = Integer.parseInt(reader.readLine());
                figure = new Rectangle(width, height);
                break;

            case "Square":
                int size = Integer.parseInt(reader.readLine());
                figure = new Square(size);
                break;
        }

        reader.close();

        figure.draw();
    }
}
