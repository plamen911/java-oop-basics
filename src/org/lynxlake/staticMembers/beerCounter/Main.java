// https://judge.softuni.bg/Contests/Practice/Index/231#3
package org.lynxlake.staticMembers.beerCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine().trim();
        while (!line.equalsIgnoreCase("End")) {
            String[] params = line.split("\\s+");
            int bought = Integer.parseInt(params[0]);
            int drank = Integer.parseInt(params[1]);
            BeerCounter.BuyBeer(bought);
            BeerCounter.DrinkBeer(drank);
            line = reader.readLine().trim();
        }
        reader.close();

        System.out.printf("%d %d%n", BeerCounter.beerInStock, BeerCounter.beersDrankCount);
    }
}
