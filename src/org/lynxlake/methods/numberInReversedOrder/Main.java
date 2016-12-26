// https://judge.softuni.bg/Contests/Practice/Index/225#4
package org.lynxlake.methods.numberInReversedOrder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String n = input.nextLine();
        input.close();

        DecimalNumber d = new DecimalNumber();

        System.out.println(d.getDigitsInReverseOrder(n));
    }
}
