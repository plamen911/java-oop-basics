// https://judge.softuni.bg/Contests/Practice/Index/225#5
package org.lynxlake.methods.fibonacciNumbers;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long startPosition = input.nextLong();
        long endPosition = input.nextLong();

        Fibonacci fibonacci = new Fibonacci();
        ArrayList<Long> myList = fibonacci.getNumbersInRange(startPosition, endPosition);

        int i = 0;
        for (Long aLong : myList) {
            System.out.print(aLong);
            if (i < myList.size() - 1) {
                System.out.print(", ");
            }
            i++;
        }
    }
}
