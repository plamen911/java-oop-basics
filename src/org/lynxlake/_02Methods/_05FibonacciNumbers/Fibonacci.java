package org.lynxlake._02Methods._05FibonacciNumbers;

import java.util.ArrayList;

class Fibonacci {
    private ArrayList<Long> myList;

    Fibonacci() {
        this.myList = new ArrayList<>();
    }

    ArrayList<Long> getNumbersInRange(long startPosition, long endPosition) {
        long firstVariable = -1L;
        long secondVariable = 1L;

        for (int i = 0; i < endPosition; i++) {
            long currentVariable = firstVariable + secondVariable;
            firstVariable = secondVariable;
            secondVariable = currentVariable;

            if (i >= endPosition) break;

            if (i >= startPosition) {
                this.myList.add(currentVariable);
            }
        }

        return this.myList;
    }
}
