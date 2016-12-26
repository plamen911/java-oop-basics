package org.lynxlake.staticMembers.beerCounter;

class BeerCounter {
    static int beerInStock = 0;
    static int beersDrankCount = 0;

    static void BuyBeer(int bottlesCount) {
        beerInStock += bottlesCount;
    }

    static void DrinkBeer(int bottlesCount) {
        beerInStock -= bottlesCount;
        beersDrankCount += bottlesCount;
    }
}
