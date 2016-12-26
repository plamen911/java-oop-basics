// https://judge.softuni.bg/Contests/Practice/Index/225#10
package org.lynxlake.methods.dateModifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String startDateStr = reader.readLine();
        String endDateStr = reader.readLine();

        DateModifier dateModifier = new DateModifier();
        dateModifier.calculate(startDateStr, endDateStr);
        System.out.println(dateModifier.getDiffDays());

        reader.close();
    }
}
