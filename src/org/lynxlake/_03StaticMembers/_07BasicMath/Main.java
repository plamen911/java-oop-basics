// https://judge.softuni.bg/Contests/Practice/Index/231#6
package org.lynxlake._03StaticMembers._07BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine().trim();
        while (!line.equalsIgnoreCase("End")) {
            String[] params = line.split("\\s+");
            double result = 0.0;
            double num1 = Double.parseDouble(params[1]);
            double num2 = Double.parseDouble(params[2]);

            switch (params[0]) {
                case "Sum":
                    result = MathUtil.sum(num1, num2);
                    break;

                case "Subtract":
                    result = MathUtil.subtract(num1, num2);
                    break;

                case "Multiply":
                    result = MathUtil.multiply(num1, num2);
                    break;

                case "Divide":
                    result = MathUtil.divide(num1, num2);
                    break;

                case "Percentage":
                    result = MathUtil.percentage(num1, num2);
                    break;
            }

            System.out.printf("%.2f%n", result);
            line = reader.readLine().trim();
        }

        reader.close();
    }
}
